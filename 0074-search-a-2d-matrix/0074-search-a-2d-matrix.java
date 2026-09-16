class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //compare with first element of each row(a[i][0]<=target) like search for 16 then after comparison shows {yes,yes , no ...}whenever first no comes then it say may be target exist in just prev of no. giving row.

        int m=matrix.length;
        int n=matrix[0].length;

        if(target<matrix[0][0] || target>matrix[m-1][n-1]){
            return false;
        }

        int low=0;
        int high=m-1;
        int row=-1;
        while(low<=high){
            int guess=low+(high-low)/2;

            if(matrix[guess][0]<=target){
                row=guess;
                low=guess+1;
            }else{
                high=guess-1;
            }
        }

        int rowlow=0,rowhigh=n-1;
        while(rowlow<=rowhigh){
            int guess=rowlow+(rowhigh-rowlow)/2;

            if(matrix[row][guess]==target){
                return true;
            }
            else if(matrix[row][guess]<target){
                rowlow=guess+1;
            }
            else{
                rowhigh=guess-1;
            }
        }

        return false;
    }
}