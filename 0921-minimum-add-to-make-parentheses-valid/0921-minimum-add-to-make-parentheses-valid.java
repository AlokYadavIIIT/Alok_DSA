class Solution {
    public int minAddToMakeValid(String s) {
        
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int count=0;
        

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    count++;
                }
            }
        }
        return count+stack.size();


    }
}