package sangku;

import java.util.*;

public class Ch06_04 {
    String mostCommonWord(String paragraph, String[] banned) {
        var bans = Arrays.asList(banned);
        var words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!bans.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        Map<String, Integer> hs = new HashMap<>();
        Set<String> ban = new HashSet<String>();
        String next = "";
        StringTokenizer st = new StringTokenizer(paragraph, " ,.;!?'");
        int max = -1;
        String maxStr = "";
        for (String s : banned)  ban.add(s);

        while (st.hasMoreTokens()) {
            next = st.nextToken();
            next = next.toLowerCase();
            if (!ban.contains(next)) {
                Integer k = hs.get(next);
                if (k == null) k = 0;
                hs.put(next, k + 1);
                if (k + 1 > max) {
                    max = k + 1;
                    maxStr = next;
                }
            }
        }
        return maxStr;
    }

}
