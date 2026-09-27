class Solution {
    public String reverseParentheses(String s) {
        
        Stack<StringBuilder> st =new Stack<>();

        StringBuilder current = new StringBuilder();

        for(char ch : s.toCharArray()){

            if(ch=='('){
                //save current level
                st.push(current);

                //start a new level
                current=new StringBuilder();

            }
            else if(ch==')'){

                //reverse current level
                current.reverse();

                //get previous level
                StringBuilder previous = st.pop();

                //add reversed content to previous level
                previous.append(current);

                //move back to previouslevel
                current = previous;
            }
            else{
                //normal character
                current.append(ch);
            }
        }
        
        return current.toString();
    }
}