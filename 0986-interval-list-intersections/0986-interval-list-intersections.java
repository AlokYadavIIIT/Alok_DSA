class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //Start thinking according to 1D-array merge;
        int n=firstList.length;
        int m=secondList.length; 
        
        List<int[]>res = new ArrayList<>();

        int i=0;
        int j=0;
        while(i<n && j<m){
            int s1=firstList[i][0];
            int e1=firstList[i][1];
            int s2=secondList[j][0];
            int e2=secondList[j][1];
//either a0>b0 or a0<b0;
            if(s1<=s2){
                if(e1>=s2){
                    int s=Math.max(s1,s2);
                    int e=Math.min(e1,e2);
                    res.add(new int[]{s,e});
                }
            }
            else{
                if(e2>=s1){
                    int s=Math.max(s1,s2);
                    int e=Math.min(e1,e2);
                    res.add(new int[]{s,e});
                }
            }
            if(e1<=e2){
                i++;
            }
            else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}