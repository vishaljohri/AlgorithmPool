__author__ = 'VISHAL'
import math
import datetime
import random

def singleIteration(ele, low, high):
    sum = 0
    startPoint = low
    endPoint = high
    flag  = 0
    minElement = ele[low]
    minElementLocation = low;

    #checking if all elements are negative
    for i in range(low,high+1):
        if ele[i] >= 0:
            flag = 1
            break;
        if minElement < ele[i]:
            minElement = ele[i]
            minElementLocation = i;
    if flag == 0:
        print("Single iteration min element = ", minElement, "location = ", minElementLocation)
        return

    #checking all other scenerios
    ansSum = 0
    for i in range(low,high+1):
        sum = sum + ele[i]
        if sum < 0:
            sum = 0
            startPoint = i+1
        else:
            if ansSum < sum:
                ansSum = sum
                endPoint = i
    print("Single iteration sum = ", ansSum, "start point = ", startPoint, "end point = ", endPoint)
    return;

def find_maximum_crossing_subarray(A, low, mid, high):

    #for left half
    left_sum = -999
    sum = 0
    midPt = mid
    while(midPt >= low):
        sum = sum + A[midPt]
        if(sum > left_sum):
            left_sum = sum
            max_left = midPt
        midPt = midPt - 1

    #for right half
    right_sum = -999
    sum = 0
    midPt = mid + 1
    while(midPt <= high):
        sum = sum + A[midPt]
        if(sum > right_sum):
            right_sum = sum
            max_right = midPt
        midPt = midPt + 1

    return max_left, max_right, left_sum + right_sum


def max(first, second, third):
    maximum = first
    if(second > first):
        maximum = second
        if(maximum < third):
            maximum = third
    else:
        if(maximum < third):
            maximum = third
    return maximum

def find_maximum_subarray_recursive(A, low, high):
    #base case
    if(low == high):
        return low, high, A[low]
    else:
        mid = (low + high)/2
        left_low, left_high, left_sum = find_maximum_subarray_recursive(A, low, mid)
        right_low, right_high, right_sum = find_maximum_subarray_recursive(A, mid+1, high)
        cross_low, cross_high, cross_sum = find_maximum_crossing_subarray(A, low, mid, high)
        if left_sum >= right_sum and left_sum >= cross_sum:
            return left_low, left_high, left_sum
        elif right_sum >= left_sum and right_sum >= cross_sum:
            return right_low, right_high, right_sum
        else:
            return cross_low, cross_high, cross_sum


eleNegative = [-7, -9, -5, -6, -2, -8]
singleIteration(eleNegative, 0 , len(eleNegative)-1)
ele = [-2, -3, 4, -1 , -2, 1, 5, -4]
eleNew = [2, 4, 5, 8, 9, 15, 2]
eleLast = [-1, -4, -5, 2, -1, 5, -4, 7, 2]
#ele = [random.randint(-100,100) for _ in range (25)]
singleIteration(ele, 0, len(ele)-1)
print("Using Divide and Conquer:")
start, end, maxi = find_maximum_subarray_recursive(eleLast, 0 , len(eleLast)-1)
print start, end, maxi

#brute force
def maxSubarrayBruteForce(ele, left, right):
    """

    :param ele:
    :param left:
    :param right:
    :return:

    """
    max_sum = ele[left]
    start = end = left
    for i in range(left, right+1):
        sum = 0
        for j in range(i, right+1):
            sum = sum + ele[j]
            if sum > max_sum:
                max_sum = sum
                start = i
                end = j
    print("O(n^2) complexity: ",start, 'and', end,'sum = ', max_sum)
    #for i in range(start, end+1):
       # print(ele[i])

print("Using brute force:")
maxSubarrayBruteForce(ele, 0, len(ele)-1)
