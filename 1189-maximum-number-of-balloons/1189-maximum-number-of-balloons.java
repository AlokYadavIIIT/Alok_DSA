class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        String s ="balloon";
        HashMap<Character,Integer> need = new HashMap<>();

        for(char ch:s.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> have = new HashMap<>();

        for(char ch:text.toCharArray()){
            have.put(ch,have.getOrDefault(ch,0)+1);
        }

        int maxuse=Integer.MAX_VALUE;
        for(char ch:s.toCharArray()){
            int d = have.getOrDefault(ch,0);
            int r = need.get(ch);
            
            maxuse=Math.min(maxuse,(d/r));
        } 

        return maxuse;     
    }
}