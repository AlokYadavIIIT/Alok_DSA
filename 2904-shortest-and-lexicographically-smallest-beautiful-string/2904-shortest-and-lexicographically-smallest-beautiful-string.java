//METHOD-1:
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int low=0,count=0;

        String answer = "";
        for(int high =0;high<n;high++)
        {
            if(s.charAt(high)=='1'){
                count++;
            }

            while(count==k){
                String current = s.substring(low,high+1);

                if(answer.equals("")||current.length()<answer.length()||(current.length()==answer.length()&& current.compareTo(answer)<0)){
                    answer=current;
                }

                if(s.charAt(low)=='1'){
                    count--;
                }

                low++;
            }
        }
        
        return answer;
    }
}



//METHOD-2:
// class Solution {
//     public String shortestBeautifulSubstring(String s, int k) {
//         int n = s.length();

//         ArrayList<Character> out = new ArrayList<>();
//         ArrayList<String> output = new ArrayList<>();

//         int count=0;
//         int low=0;
//         int high=0;

//         while(high<n){
//             char c = s.charAt(high);

//             out.add(c);

//             if(c=='1'){
//                 count++;
//             }
            
//             high++;

//             while(count==k){
//                 //convert arrayList to string
//                 StringBuilder sb =new StringBuilder();

//                 for(char ch:out){
//                     sb.append(ch);
//                 }

//                 output.add(sb.toString());

//                 char removed = out.remove(0);

//                 if(removed =='1'){
//                     count--;
//                 }

//                 low++;
//             }
//         }

//         //Find shortest and lexicographically smallest
//         String answer = "";

//         for(String str:output){
//             if(answer.equals("")|| str.length()<answer.length() || (str.length()==answer.length() && str.compareTo(answer)<0)){
//                 answer=str;
//             }
//         }

//         return answer;
//     }
// }