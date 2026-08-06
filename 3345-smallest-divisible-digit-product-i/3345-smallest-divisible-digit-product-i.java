class Solution {
    public int findprod(int n){
        int prod=1;
        while(n!=0){
            prod=prod*(n%10);
            n=n/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        int ans;
        int prod;

        while(true){
            prod=findprod(n);
            if(prod%t==0){
                ans=n;
                return ans;
            }
            else{
                n++;
            }
        }
    }
}