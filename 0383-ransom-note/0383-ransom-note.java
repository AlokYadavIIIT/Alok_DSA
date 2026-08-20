// //METHOD-1:
// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         int n = magazine.length();

//         HashMap<Character,Integer> freq = new HashMap<>();

//         for(int i=0;i<n;i++){
//             char c = magazine.charAt(i);
//             freq.put(c,freq.getOrDefault(c,0)+1);
//         }

//         for(int i=0;i<ransomNote.length();i++){
//             char c = ransomNote.charAt(i);
            
//             if(freq.getOrDefault(c,0)==0){
//                 return false;
//             }

//             freq.put(c,freq.get(c)-1);
//         }
    
//         return true;
//     }
// }


//METHOD-2:
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = magazine.length();

        HashMap<Character,Integer> freq1 = new HashMap<>();

        for(int i=0;i<n;i++){
            char c = magazine.charAt(i);
            freq1.put(c,freq1.getOrDefault(c,0)+1);
        }

        int m = ransomNote.length();
        HashMap<Character,Integer> freq2 = new HashMap<>();

        for(int i=0;i<m;i++){
            char c = ransomNote.charAt(i);
            freq2.put(c,freq2.getOrDefault(c,0)+1);
        }
    
        for(int i=0;i<m;i++){
            char c = ransomNote.charAt(i);

            if(freq1.getOrDefault(c,0)<freq2.get(c)){
                return false;
            }
        }
        return true;
    }
}