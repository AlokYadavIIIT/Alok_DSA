class Solution {
    public int squaresum(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            n=n/10;
            sum+=(digit*digit);
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        while(fast!=1){
            slow=squaresum(slow);
            fast=squaresum(fast);
            fast=squaresum(fast);
            if(slow==fast && slow!=1){
                return false;
            }
        }
        return true;
    }
}