class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        int n=s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            //opening bracket
            if(c=='('|| c=='{' || c=='['){
                st.push(c);
            }//closing brackets.
            else{
                if(st.isEmpty()){
                    return false;
                }
                if(c==')' && st.peek()=='('){
                    st.pop();
                }
                else if(c=='}' && st.peek()=='{'){
                    st.pop();
                }
                else if(c==']' && st.peek()=='['){
                    st.pop();
                }else if(c!=st.peek()){
                    return false;
                }
            }
        }

        return st.isEmpty();
        
        // if(!st.isEmpty()){
        //     return false;
        // }
        // else{
        //     return true;
        // }
    }
}