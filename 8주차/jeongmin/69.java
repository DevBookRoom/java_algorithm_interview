class Solution {
    public void sortColors(int[] nums) {

        //red와 blue는 양쪽 끝 포인터이며,white는 중앙에서 움직이는 포인터
        int red=0;
        int white=0;
        int blue=nums.length;

        //두값이 역전 될떄까지 반복
        while(white<blue){
            //white포인터가 중앙값보다 작다면
            if(nums[white]<1){
                int temp=nums[red];
                nums[red]=nums[white];
                nums[white]=temp;
                red++;
                white++;

            }else if(nums[white]>1){
                blue--;
                int temp=nums[white];
                nums[white]=nums[blue];
                nums[blue]=temp;
            }else{
                white++;
            }

        }

    }
}