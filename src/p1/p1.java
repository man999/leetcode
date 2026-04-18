//#1
void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
}

public static int[] twoSum(int[] nums, int target) {
    //my solution
    for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }
    return null;
    //best solution
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            int compl=target-nums[i];
//            if(map.containsKey(compl)){
//                return new int[]{map.get(compl),i};
//            }
//            map.put(nums[i],i);
//        }
//        return null;
}