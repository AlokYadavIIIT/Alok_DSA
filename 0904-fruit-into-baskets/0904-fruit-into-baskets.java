class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left=0;
        int max = 0;
        Map<Integer,Integer>freq=new HashMap<>();

        for(int right=0;right<n;right++){
            freq.put(fruits[right],freq.getOrDefault(fruits[right],0)+1);

            //shrinking the window if more than 2 types of fruit is in basket;
            while(freq.size()>2){
                int leftfruit=fruits[left];
                freq.put(leftfruit,freq.get(leftfruit)-1);
                if(freq.get(leftfruit)==0){
                    freq.remove(leftfruit);
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}