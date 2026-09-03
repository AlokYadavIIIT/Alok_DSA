class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int n=nums1.length;
        int[] nums2 = new int[n];

        boolean alleven=true;
        for(int x:nums1){
            if(x%2!=0){
                alleven=false;
                break;
            }
        }
        
        if(alleven){
            return true;
        }else{
            int minodd=Integer.MAX_VALUE;
            
            for(int x:nums1){
                if(x%2!=0 && x<minodd){
                    minodd=x;
                }
            }

            // boolean isoddmin=true;
            for(int x:nums1){
                if(x%2==0 && minodd>x){
                    return false;  
                }
            }
        }
        return true;
    }
}