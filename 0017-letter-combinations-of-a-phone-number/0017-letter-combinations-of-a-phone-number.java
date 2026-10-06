// class Solution {
    
//     public List<String> letterCombinations(String digits) {

//         List<String> result = new ArrayList<>();

//         if (digits.length() == 0) {
//             return result;
//         }

//         String[] map = {
//             "", "", "abc", "def",
//             "ghi", "jkl", "mno",
//             "pqrs", "tuv", "wxyz"
//         };

//         backtrack(digits, 0, "", result, map);

//         return result;
//     }

//     private void backtrack(
//         String digits,
//         int index,
//         String current,
//         List<String> result,
//         String[] map
//     ) {

//         if (index == digits.length()) {
//             result.add(current);
//             return;
//         }

//         String letters = map[digits.charAt(index) - '0'];

//         for (char ch : letters.toCharArray()) {
//             backtrack(
//                 digits,
//                 index + 1,
//                 current + ch,
//                 result,
//                 map
//             );
//         }
//     }
// }




class Solution {
    
    void find(String digits, int i,StringBuilder diary,List<String> res,HashMap<Character,String> map){

        if(i==digits.length()){
            res.add(diary.toString());
            return;
        }
        String choice = map.get(digits.charAt(i));

        for(int j=0;j<choice.length();j++){
            diary.append(choice.charAt(j));
            find(digits,i+1,diary,res,map);
            diary.deleteCharAt(diary.length()-1);
        }
        return;
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        // String[] map = {
        //     "", "", "abc", "def",
        //     "ghi", "jkl", "mno",
        //     "pqrs", "tuv", "wxyz"
        // };

        HashMap<Character, String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        find(digits,0,new StringBuilder(),result,map);

        return result;
    }
}