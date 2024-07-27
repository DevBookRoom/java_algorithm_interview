import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String p : participant) {
            // 이름별 카운트값 1 증가
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        for (String player : completion) {
            // 이름별 카운트값 다시 감소시킴
            participantMap.put(player, participantMap.get(player) - 1);
            // 여기서 값 0인애들 == 완주한 애들 -> 지우고 남아있는 애들이 완주 못한 애들
            if (participantMap.get(player) == 0) {
                participantMap.remove(player);
            }
        }

        // 남아 있는 이름 찾기
        for (String player : participantMap.keySet()) {
            return player;
        }

        return null;    // 항상 1명은 있음
    }
}
