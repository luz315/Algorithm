class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<length; i++){
            int check = target - nums[i]; 
            if(map.containsKey(check)){
                return new int[] {map.get(check),i}; 
            }
            map.put(nums[i],i);  
        }
        return new int[]{};
    }
}