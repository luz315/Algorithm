class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[k];
        
        for(int n:nums){
            map.compute(n,(key,value) -> map.getOrDefault(n,0)+1);
        }

        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(b.getValue(),a.getValue())
        );

        pq.addAll(map.entrySet());
        
        for(int i = 0; i<k; i++){
            answer[i]=pq.poll().getKey();
        }
        return answer;
    }
}