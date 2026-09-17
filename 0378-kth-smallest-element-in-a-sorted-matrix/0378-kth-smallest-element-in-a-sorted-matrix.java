class Solution {

    public int find(int[][]matrix,int m,int n,int guess){

        int row=m-1;
        int col=0;
        int ans=0;
        while(row>=0 && col<n){

            int a = matrix[row][col];
            if(a>guess){
                row--;
            }
            else{
                ans+=(row+1);
                col++;
            }
        }
        return ans;
    }
    public int kthSmallest(int[][] matrix, int k) {
        
        int m=matrix.length;
        int n=matrix[0].length;

        int res=-1;
        int low=matrix[0][0],high=matrix[m-1][n-1];
        while(low<=high){
            int guess=low+(high-low)/2;

//count of numbers less than or equal to guess;
            int numbers=find(matrix,m,n,guess);
            if(numbers<k){
                low=guess+1;
            }else{
                res=guess;
                high=guess-1;
            }
        }

        return res;
    }
}