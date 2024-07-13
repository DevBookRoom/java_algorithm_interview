import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left,right,sum;
        List<List<Integer>>results=new ArrayList<>();
        Arrays.sort(nums);


        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for(int k=j+1;k<nums.length;k++){
                    if(k>j+1&&nums[k]==nums[k-1])
                        continue;
                    if(nums[i]+nums[j]+nums[k]==0){
                        results.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
    }
}