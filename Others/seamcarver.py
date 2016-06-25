__author__ = 'VISHAL'

from pylab import *
from skimage import img_as_float
from skimage import filters
import numpy


def vert_triple(given_matrix, i, j):
    """
    calculates and returns neighbouring pixels for a pixel in vertical path
    :param given_matrix: given matrix
    :param i: ith location of a pixel
    :param j: jth location of a pixel
    :return: neighbouring pixels
    """
    rows, cols = given_matrix.shape
    if j == 0:  # for checking left edge
        return float("inf"), given_matrix[i-1, j], given_matrix[i-1, j+1]
    elif j == cols-1:  # for checking right edge
        return given_matrix[i-1, j-1], given_matrix[i-1, j], float("inf")
    else:
        return given_matrix[i-1, j-1], given_matrix[i-1, j], given_matrix[i-1, j+1]


def cum_vert_matrix(given_energy_matrix):
    """
    calculating cumulative matrix for vertical paths
    :param given_energy_matrix: given energy matrix
    :return: cumulative vertical matrix
    """
    temp_array = numpy.zeros(given_energy_matrix.shape, dtype=numpy.float)
    temp_array[0, :] = given_energy_matrix[0, :]
    rows, cols = given_energy_matrix.shape
    for i in range(1, rows):
        for j in range(0, cols):
            temp_array[i, j] = given_energy_matrix[i][j] + min(vert_triple(temp_array, i, j))
    return temp_array


def find_seam(cumulative_matrix):
    """
    backtracking and storing best vertical path in 1D array
    :param cumulative_matrix: given cumulative matrix
    :return: vertical seam
    """
    rows, cols = cumulative_matrix.shape
    col_ascending = numpy.argsort(cumulative_matrix)
    start_point = col_ascending[rows-1][0]
    vert_path = numpy.zeros(rows, dtype=numpy.uint32)
    j = vert_path[rows-1] = start_point
    for i in range(rows-2, -1, -1):
        j = vert_path[i] = j + numpy.argmin(vert_triple(cumulative_matrix, i, j)) - 1

    return vert_path


def remove_seam(img, seam):
    """
    remove seam from the image return slice with width W-1
    :param img: given image
    :param seam: vertical seam to be removed
    :return: new image with vertical seam removed
    """
    rows, cols = img.shape[:2]
    new_image = numpy.array([img[i, :][numpy.arange(cols) != seam[i]] for i in range(rows)])
    return new_image


def dual_gradient_energy(img):
    """
    calculates energy at each pixel in the image and stores in new matrix
    :param img: given image
    :return: WXH array of floats, having energy of each pixel in image
    """
    red = img[:, :, 0]
    green = img[:, :, 1]
    blue = img[:, :, 2]
    gradient_horizontal_red = filters.sobel_h(red)
    gradient_vertical_red = filters.sobel_v(red)
    gradient_horizontal_green = filters.sobel_h(green)
    gradient_vertical_green = filters.sobel_v(green)
    gradient_horizontal_blue = filters.sobel_h(blue)
    gradient_vertical_blue = filters.sobel_v(blue)
    horizontal_energy = numpy.square(gradient_horizontal_red) + numpy.square(gradient_horizontal_green) + numpy.square(gradient_horizontal_blue)
    vertical_energy = numpy.square(gradient_vertical_red) + numpy.square(gradient_vertical_green) + numpy.square(gradient_vertical_blue)
    energy_matrix = horizontal_energy + vertical_energy
    return energy_matrix


def plot_seam(img, seam):
    """
    plot the seam on the given image
    :param img: given image
    :param seam: vertical seam
    """
    color = (255, 0, 0)
    rows, cols = img.shape[:2]
    for i in range(0, rows):
        img[i][seam[i]] = color
    subplot(1, 4, 3)
    title("Image with Seam")
    imshow(img)


def main():
    """
    testing the functionality of seam carving an image
    """
    img = imread("Tower.jpg")
    img = img_as_float(img)
    w, h = img.shape[:2]
    print w, h
    subplot(1, 4, 1)
    imshow(img)
    title("Original Image")

    new_image = img
    dual_gradient_energy_matrix = dual_gradient_energy(img)
    gray()
    subplot(1, 4, 2)
    imshow(dual_gradient_energy_matrix)
    title("Dual Gradient")

    cumulative_vertical_matrix = cum_vert_matrix(dual_gradient_energy_matrix)

    number_iteration = 40  # testing with 40 iterations
    for i in range(number_iteration):
        vertical_seam = find_seam(cumulative_vertical_matrix)
        print "deleting the seam", i+1
        plot_seam(new_image, vertical_seam)
        new_image = remove_seam(new_image, vertical_seam)
        dual_gradient_energy_matrix = remove_seam(dual_gradient_energy_matrix, vertical_seam)
        cumulative_vertical_matrix = cum_vert_matrix(dual_gradient_energy_matrix)

    print "after deleting all the seams, final image is:"
    subplot(1, 4, 4)
    imshow(new_image)
    title("Final Image")
    show()


if __name__ == '__main__':
    main()
    import doctest
    doctest.testmod()
