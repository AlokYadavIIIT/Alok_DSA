//METHOD-1:
// class Solution {
//     class Pair{
//         char first;
//         int second;

//         Pair(char first,int second){
//             this.first=first;
//             this.second=second;
//         }
//     }
//     public String removeDuplicates(String s, int k) {
//         int n=s.length();
//         Stack<Pair> st = new Stack<>();
        
//         for(int i=0;i<n;i++){
//             char c = s.charAt(i);
//             if(st.isEmpty()){
//                 st.push(new Pair(c,1));
//                 continue;
//             }
//             else{
//                 if(st.peek().first!=c){
//                 st.push(new Pair(c,1));
//                 continue;
//                 }
//                 else if(st.peek().first==c && st.peek().second<(k-1)){
//                     Pair p = st.peek();
//                     st.pop();
//                     st.push(new Pair(p.first,p.second+1));
//                     continue;
//                 }
//                 else{
//                     st.pop();
//                 }
//             }    
//         }
//         StringBuilder sb = new StringBuilder();
//         while(!st.isEmpty()){
//             Pair p = st.peek();
//             st.pop();
//             while(p.second-->0){
//                 sb.append(p.first);
//             }
//         }
//         return sb.reverse().toString();
//     }
// }


//METHOD-2:
class Solution {

    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!st.isEmpty() && st.peek().ch == c) {

                st.peek().count++;

                if (st.peek().count == k) {
                    st.pop();
                }

            } else {
                st.push(new Pair(c, 1));
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            Pair p = st.pop();

            for (int i = 0; i < p.count; i++) {
                ans.append(p.ch);
            }
        }

        return ans.reverse().toString();
    }
}