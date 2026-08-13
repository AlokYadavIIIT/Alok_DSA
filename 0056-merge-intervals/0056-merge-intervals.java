class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        //Sort intervals according to starting points
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
        List<int[]>res =new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<n;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];

            if(end>=s){
                end = Math.max(end,e);
                continue;
            }else{
                //NO overlap ->store previous interval
                res.add(new int[]{start,end});
                start = s;
                end = e;
            }
        }
        //Add the last interval
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }
}