class Solution {
    public int maximumSum(int[] arr) {
       int n=arr.length;
       int i=0;
       int nodelete=arr[i];
       int onedelete=Integer.MIN_VALUE;//This says i don't have a one deletion answer yet.
       int res = arr[i];
       for(i=1;i<n;i++){
        int prevnodelete=nodelete;//if we want to delete present value
        int prevonedelete = onedelete;

        nodelete=Math.max(arr[i],nodelete+arr[i]);
        int v2;
        //Here we are calculating one deletion part in two ways
        if(prevonedelete==Integer.MIN_VALUE)
            v2=arr[i];//Here if this is first value of ondedeletion then need to delete atleast one previously .So,we have only one option as i=0;this use just for i=1 iteration.
        else
            v2=prevonedelete+arr[i];//This means we previously deleted something;uses after i=1
        onedelete=Math.max(v2,prevnodelete);
        res=Math.max(res,Math.max(nodelete,onedelete));
       } 
       return res;
    }
}