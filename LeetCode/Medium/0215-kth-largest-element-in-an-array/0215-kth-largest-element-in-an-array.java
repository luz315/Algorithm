class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int n:nums){
            pq.offer(n);

            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
