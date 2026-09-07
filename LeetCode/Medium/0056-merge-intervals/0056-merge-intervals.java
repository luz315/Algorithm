class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int ns = 0;
        int ne = 0;

        for(int i = 1; i<intervals.length; i++){
            ns = intervals[i][0];
            ne = intervals[i][1];
           
            if(end>=ns){
                end = Math.max(end,ne);
            }else{
                list.add(new int[]{start,end});
                start = ns;
                end = ne;
            }
        }
        list.add(new int[]{start,end});

        return list.toArray(new int[0][]);
    }
}