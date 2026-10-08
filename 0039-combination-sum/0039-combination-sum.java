class Solution {

    public void find(int[] a,int n,int i,List<Integer> diary,int sum ,int target, List<List<Integer>> res){

        if(i==n){
            if(sum==target){//lena h
                res.add(new ArrayList<>(diary));
            }
            return ;//else (nhi lena)
        }

        find(a,n,i+1,diary,sum,target,res);//nhi lena h(choice 1)
        
        if(a[i]+sum<=target){//choice 2
            diary.add(a[i]);
            sum +=a[i]; 
            find(a,n,i,diary,sum,target,res);//check for same value again
            diary.remove(diary.size()-1);//if again adding exceeds target mean we have to add next and to add next we have to take a step back by pop(like [2,3,5,7] target=7) in this diary as[2,2,2]since if again 2 then sum=8 so, to add 3 we have to make as  [2,2].
            sum = sum-a[i];
        }
        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        int n = candidates.length;

        find(candidates,n,0,new ArrayList<>(),0,target,res);

        return res;

    }
}