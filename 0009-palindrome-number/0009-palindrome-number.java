class Solution {
    public boolean isPalindrome(int x) {
        
        String s = String.valueOf(x);
        int n = s.length();
        int left=0,right=n-1;
        while(left<=right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l==r){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}