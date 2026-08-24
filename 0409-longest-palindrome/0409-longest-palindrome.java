class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();

        HashMap<Character,Integer> have = new HashMap<>();

        for(char ch : s.toCharArray()){
            have.put(ch,have.getOrDefault(ch,0)+1);
        }

        ArrayList<Integer> value = new ArrayList<>(have.values());

        int maxlength=0;
        boolean hasOdd = false;
        for(int i=0;i<have.size();i++){
            if(value.get(i)%2 ==0){
                maxlength = maxlength+value.get(i);
            }else{
                hasOdd = true;
                maxlength = maxlength+value.get(i)-1;
            }
        }

        if(hasOdd){
            maxlength++;
        }
        return maxlength;
    }
}