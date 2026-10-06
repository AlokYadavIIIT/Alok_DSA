class Solution {

    public void find(int open,int close,int n,StringBuilder temp,List<String> ls){
        if(open==n && close==n){
            ls.add(temp.toString());
            return;
        }
        if(open<n){
            temp.append('(');
            find(open+1,close,n,temp,ls);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(')');
            find(open,close+1,n,temp,ls);
            temp.deleteCharAt(temp.length()-1);
        }
        return ;
    }

    public List<String> generateParenthesis(int n) {
        
        List<String> ls = new ArrayList<>();
        StringBuilder s = new StringBuilder();

        find(0,0,n,s,ls);

        return ls;
    }
}