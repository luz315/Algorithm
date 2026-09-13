class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        back(result, new ArrayList<>(), visit, 0, nums);

        return result;
    }

    private void back(List<List<Integer>> result, List<Integer> list, boolean[] visit, int depth, int[] nums){
        if(depth == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(!visit[i]){
                list.add(nums[i]);
                visit[i]=true;
                back(result,list, visit, depth+1, nums);
                list.remove(list.size() - 1);
                visit[i]=false;
            }
        }
    }
}