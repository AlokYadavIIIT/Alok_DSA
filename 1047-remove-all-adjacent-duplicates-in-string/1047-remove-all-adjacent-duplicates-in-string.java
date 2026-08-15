class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
                continue;
            }
            if(c==st.peek()){
                st.pop();
            }else{
                st.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.reverse().toString();



        // String res="";
        // while(!st.isEmpty()){
        //     res+=st.pop();
        // }
        // String reverse="";
        // for(int i=res.length()-1;i>=0;i--){
        //     reverse+=res.charAt(i);
        // }
        // return reverse;
    }
}