import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int sum = 0;

        char[] jewelsArray = jewels.toCharArray();

        for (char c : stones.toCharArray()) {
            for (char jew : jewelsArray) {
                if (c == jew) {
                    sum++;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numJewelsInStones("aA", "aAAbbbb");

    }

    public int numJewelsInStones2(String jewels, String stones) {

        int count = 0;
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char jewel : jewels.toCharArray()) {
            if (hashMap.containsKey(jewel)) {
                hashMap.put(jewel, hashMap.get(jewel) + 1);
            } else {
                hashMap.put(jewel, 1);
            }
        }

        for (char stone : stones.toCharArray()) {
            if (hashMap.containsKey(stone)) {
                count += hashMap.get(stone);
            }
        }

        return count;
    }
}
