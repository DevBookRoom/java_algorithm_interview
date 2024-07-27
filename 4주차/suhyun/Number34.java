class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();

        for (String p : participant) {
            m.put(p, m.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            int left = m.get(c);
            if (left == 1)
                m.remove(c);
            else
                m.put(c, left - 1);
        }

        return m.entrySet().iterator().next().getKey();
    }
}