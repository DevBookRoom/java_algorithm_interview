class Solution {
/*    //1. 브루노투스방법(무차별 대입)
    public int[] twoSum(int[] nums, int target) {
        int []answer=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target==nums[i]+nums[j]){
                    answer[0]=i;
                    answer[1]=j;
                    break;

                }

            }
        }
        return answer;
    }*/
/*//2. 첫번째 수를 뺸 결과 키 조회
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap=new HashMap<>();
        //키와 값을 바꿔서 맵으로 저장
        for(int i=0;i<nums.length;i++){
            numsMap.put(nums[i],i);//키,값
        }

        //target에서 첫번째 수를 뺸 결과를 키로 조회하고 현재 인덱스가 아닌경우 정답으로 리턴
        for(int i=0;i<nums.length;i++){
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i,nums.get(target-nums[i]);
                }

            }
        }return null;

    }*/
//3. 조회구조개선
public int[] twoSum(int[] nums, int target) {
    int []answer=new int[2];
    //하나의 for반복으로 통합
    for(int i=0;i<nums.length;i++){
        //target에서 num을 뺸 값이 있으면 정답으로 리턴
        if(numsMap.containsKey(target-nums[i])){
            return new int[]{numsMap.get(target-nums[i]),i}
        }
        numsMap.put(nums[i],i);
    }
    return null
}
}