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
        int prod;
        while(true){
            prod=findprod(n);
            if(prod%t==0){
                return n;
            }
            else{
                n++;
            }
        }
    }
}