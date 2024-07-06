
//[Leetcode 42] Trapping Rain Water - 투 포인터
class Solution {
    public int trap(int[] height) {
        int sum=0;
        int left=0;
        int right=height.length-1;

        int maxL=height[left];//왼쪽 최대값
        int maxR=height[right];//오른쪽 최대값

        while(left < right){
             maxL=Math.max(height[left],maxL);//가장자리부터 큰값
             maxR=Math.max(maxR,height[right]);

            if(maxL<=maxR){
                sum+=maxL-height[left];
                left++;
            }else{
                sum+=maxR-height[right];
                right--;
            }
        }
        return sum;
    }
}