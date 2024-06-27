package sangku;

import java.util.*;

public class Ch06_05 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) counts[s.charAt(i) - 'a']++;
            int hash = Arrays.hashCode(counts);
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (int key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
