// class Solution {
//     public boolean isPalindrome(int x) {
        
//         String s = String.valueOf(x);
//         int n = s.length();
//         int left=0,right=n-1;
//         while(left<=right){
//             char l = s.charAt(left);
//             char r = s.charAt(right);
//             if(l==r){
//                 left++;
//                 right--;
//             }
//             else{
//                 return false;
//             }
//         }
//         return true;
//     }
// }




class Solution {
    public boolean isPalindrome(int x) {
        
          if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverse = 0;

        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return x == reverse || x == reverse / 10;
    }
}