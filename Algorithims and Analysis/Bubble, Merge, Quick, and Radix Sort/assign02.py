

"""
Assign 02 - Christian Lopez.

Credits:
    * Worked with Connor Meek for most of the code.
    * Talked with Devin Schulist and Sean Kruse but mostly for ideas.
    * Worked with Theodore Crandall to debug some persitant issues.
    * For merg sort I used the sildes for the split by 2
    * https://www.geeksforgeeks.org/python-program-for-bubble-sort/
    * https://stackoverflow.com/questions/20175380/quick-sort-python-recursion
    * https://chat.openai.com/chat
    * http://pages.di.unipi.it/marino/pythonads/SortSearch/TheMergeSort.html
    * https://www.geeksforgeeks.org/3-way-merge-sort/
    * https://gist.github.com/luccabb/78b990342fa68c920ff8ff71c63e
    * cad8#file-3waymergesort-py-L29 "Part of last url, indented for linter"
    * http://pages.di.unipi.it/marino/pythonads/SortSearch/TheMergeSort.html
    * https://www.guru99.com/radix-sort.html
    * https://www.programiz.com/dsa/radix-sort

Directions:
    * Complete the sorting algorithm functions that are given below. Note that
      it okay (and probably helpful) to define auxiliary/helper functions that
      are called from the functions below.  Refer to the README.md file for
      additional info.

    * NOTE: Remember to add a docstring to each function,
      and that a reasonable coding style is followed
      (e.g. blank lines between functions).
      Your program will not pass the tests if this is not done!

    * Be sure that you implement your own sorting functions since.
      No credit will be given if Python's built-in sort function is used.
"""

import time
import random
import sys
sys.setrecursionlimit(500000)


def bubbleSort(a_list):
    """Preforms a bubble sort algorithim, given an array."""
    start_time = time.time()
    # outerLoop goes through entire a_Listay
    for x in range(len(a_list)):
        swapped = False
        # Innerloop compares current element and l element
        # to see which is larger.
        # if l element is smaller than current element swap them.
        for y in range(0, len(a_list) - 1 - x):
            if a_list[y + 1] < a_list[y]:
                currentElement = a_list[y]
                lElement = a_list[y + 1]
                a_list[y + 1] = currentElement
                a_list[y] = lElement
                swapped = True
        if not swapped:
            break
    elapsed_time = time.time() - start_time
    return (a_list, elapsed_time)


def mergeSort(a_list, split_by_k=2):
    """Preforms a merge sort algorithim, given an array and number."""
    start_time = time.time()
    # code came from slides for split by 2
    if split_by_k == 2 and len(a_list) > 1:
        mid = len(a_list) // 2
        leftList = a_list[:mid]
        rightList = a_list[mid:]
        mergeSort(leftList, split_by_k=2)
        mergeSort(rightList, split_by_k=2)
        # leftlist index
        i = 0
        # rightList indez
        r = 0
        # a_list index
        k = 0
        while i < len(leftList) and r < len(rightList):
            if leftList[i] < rightList[r]:
                a_list[k] = leftList[i]
                i += 1
            else:
                a_list[k] = rightList[r]
                r += 1
            k = k + 1
        while i < len(leftList):
            a_list[k] = leftList[i]
            i += 1
            k += 1
        while r < len(rightList):
            a_list[k] = rightList[r]
            r += 1
            k += 1
    elif split_by_k == 3 and len(a_list) > 1:
        temp = []
        temp = a_list.copy()
        mergeRecursiveSorting(temp, 0, len(a_list), a_list)
        a_list = temp.copy()
    elapsed_time = time.time() - start_time
    return (a_list, elapsed_time)


def mergeRecursiveSorting(a_list, low, high, temp):
    """Preforms recusive merge calls when split_by_k=3."""
    if (high - low >= 2):
        # mid1 is the high for the left list
        mid1 = low + ((high - low) // 3)
        # mid2 is the high for the mid list
        mid2 = low + 2 * ((high - low) // 3) + 1
        mergeRecursiveSorting(temp, low, mid1, a_list)
        mergeRecursiveSorting(temp, mid1, mid2, a_list)
        mergeRecursiveSorting(temp, mid2, high, a_list)
        merge(temp, low, mid1, mid2, high, a_list)
    else:
        return


def merge(a_list, low, mid1, mid2, high, temp):
    """Preforms sorted merging part for each range of array list."""
    # Range1: (i, mid1)
    # Range2: (m, mid2)
    # Range3: (r, high)
    # left list index
    i = low
    # middle list index
    m = mid1
    # right list index
    r = mid2
    # temp index
    k = low
    # Each while condition checks for the range of each list
    # and sorts a_list accordingly
    while i < mid1 and m < mid2 and r < high:
        if a_list[i] < a_list[m] and a_list[i] < a_list[r]:
            temp[k] = a_list[i]
            i += 1
        elif a_list[m] < a_list[i] and a_list[m] < a_list[r]:
            temp[k] = a_list[m]
            m += 1
        elif a_list[r] < a_list[i] and a_list[r] < a_list[m]:
            temp[k] = a_list[r]
            r += 1
        k += 1
    while i < mid1 and m < mid2:
        if a_list[i] < a_list[m]:
            temp[k] = a_list[i]
            i += 1
        else:
            temp[k] = a_list[m]
            m += 1
        k += 1
    while m < mid2 and r < high:
        if a_list[m] < a_list[r]:
            temp[k] = a_list[m]
            m += 1
        else:
            temp[k] = a_list[r]
            r += 1
        k += 1
    while i < mid1 and r < high:
        if a_list[i] < a_list[r]:
            temp[k] = a_list[i]
            i += 1
        else:
            temp[k] = a_list[r]
            r += 1
        k += 1
    while (i < mid1):
        temp[k] = a_list[i]
        k += 1
        i += 1
    while (m < mid2):
        temp[k] = a_list[m]
        k += 1
        m += 1
    while (r < high):
        temp[k] = a_list[r]
        k += 1
        r += 1


def partition(a_list, low, high, pivot_index):
    """Partitions a array returns pivot index."""
    pivot = a_list[pivot_index]
    a_list[pivot_index], a_list[high] = a_list[high], a_list[pivot_index]
    i = low
    for j in range(low, high):
        if a_list[j] <= pivot:
            a_list[i], a_list[j] = a_list[j], a_list[i]
            i += 1
    a_list[i], a_list[high] = a_list[high], a_list[i]
    return i


def quickSortHelper(a_list, low, high, pivot):
    """Recusivly sorts given array and range."""
    if low < high:
        # addresses first and middle pivot index contition
        if pivot == "first":
            pivot_index = low
        elif pivot == "middle":
            pivot_index = (low + high) // 2
        else:
            pivot_index = low
        pivot_index = partition(a_list, low, high, pivot_index)
        quickSortHelper(a_list, low, pivot_index - 1, pivot)
        quickSortHelper(a_list, pivot_index + 1, high, pivot)
    return (a_list)


def quickSort(a_list, pivot='first'):
    """Preforms quicksort algorithim for pivot being in the first or middle."""
    start_time = time.time()
    a_list = quickSortHelper(a_list, 0, len(a_list) - 1, pivot)
    elapsed_time = time.time() - start_time
    return (a_list, elapsed_time)


def radixSort(a_list):
    """Proforms a radix sort algorithim when given a array."""
    start_time = time.time()
    digitPos = 1
    maxNum = max(a_list)
    while maxNum // digitPos > 0:
        count(a_list, digitPos)
        digitPos *= 10
    elapsed_time = time.time() - start_time
    return (a_list, elapsed_time)


def count(a_list, digitPos):
    """Sorts an array of number based on digit position."""
    temp = [0] * len(a_list)
    countList = [0] * 10
    for each in range(0, len(a_list)):
        position = a_list[each] // digitPos
        countList[position % 10] += 1
    for each in range(1, 10):
        countList[each] += countList[each - 1]
    x = len(a_list) - 1
    while x >= 0:
        position = a_list[x] // digitPos
        temp[countList[position % 10] - 1] = a_list[x]
        countList[position % 10] -= 1
        x = x - 1
    for each in range(0, len(a_list)):
        a_list[each] = temp[each]


def assign02_main():
    """To be run when our program is run standalone."""
    list1 = list(range(5000))
    random.seed(1)
    random.shuffle(list1)

    # list1 = [54, 26, 93, 17, 77, 31, 44, 55, 20, 19]
    # helpful for early testing

    # run sorting functions
    bubbleRes = bubbleSort(list(list1))
    mergeRes2 = mergeSort(list(list1), split_by_k=2)
    mergeRes3 = mergeSort(list(list1), split_by_k=3)
    quickResA = quickSort(list(list1), pivot='first')
    quickResB = quickSort(list(list1), pivot='middle')
    radixRes = radixSort(list(list1))

    # Print results
    print(f"\nlist1 results (randomly shuffled w/ size = {len(list1)})")
    print(list1[:10])
    print(f"  bubbleSort time: {bubbleRes[1]:.4f} sec")
    print(bubbleRes[0][:10])
    print(f"  mergeSort2 time: {mergeRes2[1]:.4f} sec")
    print(mergeRes2[0][:10])
    print(f"  mergeSort3 time: {mergeRes3[1]:.4f} sec")
    print(mergeRes3[0][:10])
    print(f"  quickSortA time: {quickResA[1]:.4f} sec")
    print(quickResA[0][:10])
    print(f"  quickSortB time: {quickResB[1]:.4f} sec")
    print(quickResB[0][:10])
    print(f"  radixSort time: {radixRes[1]:.4f} sec")
    print(radixRes[0][:10])

    # Try with a list sorted in reverse order (worst case for quicksort)
    list2 = list(range(6000, 1000, -1))

    # run sorting functions
    bubbleRes = bubbleSort(list(list2))
    mergeRes2 = mergeSort(list(list2), split_by_k=2)
    mergeRes3 = mergeSort(list(list2), split_by_k=3)
    quickResA = quickSort(list(list2), pivot='first')
    quickResB = quickSort(list(list2), pivot='middle')
    radixRes = radixSort(list(list2))

    # Print results
    print(f"\nlist2 results (sorted in reverse w/ size = {len(list2)})")
    print(list2[:10])
    print(f"  bubbleSort time: {bubbleRes[1]:.4f} sec")
    print(bubbleRes[0][:10])
    print(f"  mergeSort2 time: {mergeRes2[1]:.4f} sec")
    print(mergeRes2[0][:10])
    print(f"  mergeSort3 time: {mergeRes3[1]:.4f} sec")
    print(mergeRes3[0][:10])
    print(f"  quickSortA time: {quickResA[1]:.4f} sec")
    print(quickResA[0][:10])
    print(f"  quickSortB time: {quickResB[1]:.4f} sec")
    print(quickResB[0][:10])
    print(f"  radixSort time: {radixRes[1]:.4f} sec")
    print(radixRes[0][:10])


# Check if the program is being run directly (i.e. not being imported)
if __name__ == '__main__':
    assign02_main()
