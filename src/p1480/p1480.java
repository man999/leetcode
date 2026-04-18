//#1480
void main() {
    System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
}

public static int[] runningSum(int[] nums) {
    //my solution
    int[] res = new int[nums.length];
    res[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        res[i] = res[i - 1] + nums[i];
    }
    return res;
}
