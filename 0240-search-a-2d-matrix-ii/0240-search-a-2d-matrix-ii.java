class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length;//row
        int n=matrix[0].length;//column

        int row=m-1,col=0;
        while(row>=0 && col<n){

            int guess=matrix[row][col];
            if(guess==target){
                return true;
            }
            else if(guess<target){
                col++;
            }
            else{
                row--;
            }
            
        }

        return false;
    }
}