class Solution {

    public int find(int m,int n,int k){

        int row=m;
        int col=1;
        int ans=0;

        while(row>=1 && col<=n){

            int a=row*col;
            
            if(a>k){
                row--;
            }else{
                ans+=row;
                col++;
            }
        }
        return ans;

    }
    public int findKthNumber(int m, int n, int k) {
        
        int low=1,high=m*n;
        int res=-1;

        while(low<=high){

            int guess=low+(high-low)/2;

            int numbers=find(m,n,guess);
            if(numbers<k){
                low=guess+1;
            }
            else{
                res=guess;
                high=guess-1;
            }

        }

        return res;
    }
}