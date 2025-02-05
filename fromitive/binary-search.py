def binary_search(target, arr):
    left = 0 
    right = len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if target == arr[mid]:
            return mid
        if arr[mid] < target:
            left = mid + 1
        elif arr[mid] > target:
            right = mid - 1
    print('can inserted {} index {}'.format(target, left))
    return -1

def binary_search_duplicates_right_most(target, arr):
    left = 0
    right = len(arr) - 1
    while left < right:
        mid = (left + right) // 2
        if arr[mid] > target:
            right = mid
        else:
            left = mid + 1
    return left


def binary_search_duplicates_left_most(target, arr):
    left = 0
    right = len(arr) - 1
    while left < right:
        mid = (left + right) // 2
        if arr[mid] >= target:
            right = mid
        else:
            left = mid + 1
    return left


arr = [1,1,2,3,4,5,5,5,6,7,8]

def print_binary_search_result(num, arr):
    print(f"target {num} is at {binary_search(num,arr)}")
    print(f"target {num} is left-most at {binary_search_duplicates_left_most(num,arr)}")
    print(f"target {num} is right-most at {binary_search_duplicates_right_most(num,arr)}")

for num in arr:
    print_binary_search_result(num, arr)

print_binary_search_result(-1123, arr)
print_binary_search_result(1123, arr)