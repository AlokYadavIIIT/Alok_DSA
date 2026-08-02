class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> tt = new Stack<>();

        for(char c : s.toCharArray()){
            if(c!='#'){
                st.push(c);
            }else if(st.isEmpty()==false){
                st.pop();
            }
        }

        for(char c : t.toCharArray()){
            if(c!='#'){
                tt.push(c);
            }else if(tt.isEmpty()==false){
                tt.pop();
            }
        }

        return st.equals(tt);  
    }
}