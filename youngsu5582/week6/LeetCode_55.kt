package week6

fun canJump(nums: IntArray): Boolean {
    var last = nums.size - 1
    for (i in nums.size - 2 downTo 0) {
        if (i + nums[i] >= last) {
            last = i
        }
    }
    return last == 0
}
