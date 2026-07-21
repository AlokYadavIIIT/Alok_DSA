class Solution {
    int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    int sol1(int n) {
        int se = n*(n+1);
        return gcd(se,se-n);
    }
    public int gcdOfOddEvenSums(int n) {
        // return sol1(n);
        return n;
    }
}
/***

16 52
4  16


 */