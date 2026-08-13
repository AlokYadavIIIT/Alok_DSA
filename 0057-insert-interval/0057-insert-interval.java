class Solution {
    public int[][] merge(int[][] intervals){
        int n = intervals.length;
        List<int[]>res = new ArrayList<>();
        
        int start=intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<n;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];

            if(end>=s){
                end=Math.max(end,e);
                continue;
            }else{
                res.add(new int[]{start,end});
                start=s;
                end=e;
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        boolean inserted = false;
        List<int[]> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];

            if(newInterval[0]<s && inserted == false){
                res.add(new int[]{newInterval[0],newInterval[1]});
                inserted=true;
            }
            res.add(new int[]{s,e});  
        }
        //Insertion at last position
        if(!inserted){
            res.add(new int[]{newInterval[0],newInterval[1]});
        }
        return merge(res.toArray(new int[res.size()][]));
    }
}