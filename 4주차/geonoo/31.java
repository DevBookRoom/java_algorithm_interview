import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Boolean> hashMap = new HashMap<>();
        for (char jewel : jewels.toCharArray()) {
            hashMap.put(jewel, true);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (hashMap.containsKey(stone)) {
                count++;
            }
        }

        return count;
    }
}
