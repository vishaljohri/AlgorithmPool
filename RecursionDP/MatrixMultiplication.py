__author__ = 'VISHAL'
import numpy
from numpy import *
def matrixMultiplication(A, B):
    """
    :param A: first matrix
    :param B: second marix
    :return: product of matrices A and B

    >>> matrixMultiplication(([1,2],[4,5]), ([0,2],[5,1]))
    [[10, 4], [25, 13]]
    """
    A = asarray(A)
    B = asarray(B)
    n = len(A)
    #C = numpy.empty((n, n))
    C = [[0 for j in xrange(0, n)] for i in xrange(0, n)]
    for i in range(0, n):
        for j in range(0, n):
            C[i][j] = 0
            for k in range(0, n):
                C[i][j] = C[i][j] + A[i][k]*B[k][j]
    return C

'''
Implementing Strassen algorithm for matrix multiplication
'''


def addMatrices(A, B):
    n = len(A)
    C = [[0 for j in xrange(0, n)] for i in xrange(0, n)]
    for i in range(0, n):
        for j in range(0, n):
            C[i][j] = A[i][j] + B[i][j]
    return C


def subtractMatrices(A, B):
    n = len(A)
    C = [[0 for j in xrange(0, n)] for i in xrange(0, n)]
    for i in range(0, n):
        for j in range(0, n):
            C[i][j] = A[i][j] - B[i][j]
    return C


def strassenAlgo(A, B):
    """

    :param A:
    :param B:
    :return:
    >>> strassenAlgo(([1,2,7,0],[4,5,2,5],[4,7,0,1],[4,3,2,1]),([0,2,5,9],[5,1,8,0],[5,2,1,4],[1,2,3,4]))
    [[45, 18, 28, 37], [40, 27, 77, 64], [36, 17, 79, 40], [26, 17, 49, 48]]
    """
    n = len(A)
    if(n <= 2):
        return matrixMultiplication(A, B)
    else:
        subMatrixSize = n/2
        A11 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]
        A12 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]
        A21 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]
        A22 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]

        B11 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]
        B12 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]
        B21 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]
        B22 = [[0 for j in xrange(0, subMatrixSize)] for i in xrange(0, subMatrixSize)]

        #dividing matrices
        for i in range(0, subMatrixSize):
            for j in range(0, subMatrixSize):
                A11[i][j] = A[i][j]
                A12[i][j] = A[i][j + subMatrixSize]
                A21[i][j] = A[i + subMatrixSize][j]
                A22[i][j] = A[i + subMatrixSize][j + subMatrixSize]

                B11[i][j] = B[i][j]
                B12[i][j] = B[i][j + subMatrixSize]
                B21[i][j] = B[i + subMatrixSize][j]
                B22[i][j] = B[i + subMatrixSize][j + subMatrixSize]

        #calculate new matrices M1 to M7
        M1 = strassenAlgo(addMatrices(A11, A22), addMatrices(B11, B22))
        M2 = strassenAlgo(addMatrices(A21, A22), B11)
        M3 = strassenAlgo(A11, subtractMatrices(B12, B22))
        M4 = strassenAlgo(A22, subtractMatrices(B21, B11))
        M5 = strassenAlgo(addMatrices(A11,A12), B22)
        M6 = strassenAlgo(subtractMatrices(A21, A11), addMatrices(B11, B12))
        M7 = strassenAlgo(subtractMatrices(A12, A22), addMatrices(B21, B22))

        #calculating C
        C11 = subtractMatrices(addMatrices(addMatrices(M1, M4), M7), M5)  # C1 = M1 + M4 + M7 - M5
        C12 = addMatrices(M3, M5)  # C12 = M3 + M5
        C21 = addMatrices(M2, M4)  # C21 = M2 + M4
        C22 = subtractMatrices(addMatrices(addMatrices(M1, M3), M6), M2)  # C22 = M1 + M3 + M6 - M2
        C = [[0 for j in xrange(0, n)] for i in xrange(0, n)]
        for i in range(0, subMatrixSize):
            for j in range(0, subMatrixSize):
                C[i][j] = C11[i][j]
                C[i][j + subMatrixSize] = C12[i][j]
                C[i + subMatrixSize][j] = C21[i][j]
                C[i + subMatrixSize][j + subMatrixSize] = C22[i][j]

        return C

A = [1,2,7,0],[4,5,2,5],[4,7,0,1],[4,3,2,1]
B = [0,2,5,9],[5,1,8,0],[5,2,1,4],[1,2,3,4]

#testing brute force
print "Using brute force approach"

C = matrixMultiplication(A,B)
for i in range(0, len(C)):
        for j in range(0, len(C)):
            print C[i][j], " ",
        print


#testing strassen
print "Multiply using strassen algo"
D = strassenAlgo(A, B)
for i in range(0, len(D)):
        for j in range(0, len(D)):
            print D[i][j], " ",
        print

#testing doctest
if __name__ == '__main__':
    import doctest
    doctest.testmod()