class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer>result=new ArrayList<>();

        Queue<Integer> window=new LinkedList<>();

        int currentMax=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            window.add(nums[i]);

            if(i<k-1) continue;

            if(currentMax==Integer.MIN_VALUE){
                currentMax=window.stream().max(Integer::compareTo).get();
            }else if(currentMax<nums[i]){
                currentMax=nums[i];
            }
            result.add(currentMax);
            if(currentMax==window.poll())currentMax=Integer.MIN_VALUE;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}