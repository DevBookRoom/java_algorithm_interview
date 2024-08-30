import java.util.HashMap;
import java.util.Map;

class Solution {
    // 슬라이딩 윈도우
    public String minWindow(String s, String t) {
        // 필요한 문자 카운트 맵
        Map<Character, Integer> tCount = new HashMap<>();
        // 찾으려 하는 문자열 문자단위로 분리해서 map에 저장.
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int required = tCount.size();   // 고유한 문자 수 (문자 분리)
        int formed = 0;             // 현재 윈도우 안에서 t의 모든 문자를 포함하는 수
        Map<Character, Integer> winCounts = new HashMap<>();    // 윈도우 내 각 문자별 카운트
        int left = 0, right = 0;    // 윈도우의 좌우 포인터
        int[] ans = {-1, 0, 0};     // 길이, 시작 포인터, 끝 포인터

        // 오른쪽 포인터 확장
        while (right < s.length()) {
            char c = s.charAt(right);
            winCounts.put(c, winCounts.getOrDefault(c, 0) + 1);

            // 만약 현재 문자가 tCount의 key로 존재하고, 그 빈도가 tCount의 빈도와 같으면, formed 증가.
            if (tCount.containsKey(c) && winCounts.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // 현재 윈도우가 유효하다? -> 이제 왼쪽부터 최소 윈도우까지 줄여나가야함.
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // 아래 조건이면 현재 윈도우가 최적임을 의미함. 현재 윈도우의 크기 비교해서 최솟값을 ans에 기록.
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;  // 윈도우 길이 갱신
                    ans[1] = left;      // 윈도우 시작 인덱스 갱신
                    ans[2] = right;     // 윈도우 끝 인덱스 갱신
                }

                // 왼쪽 끝의 문자 'c'를 하나씩 윈도우에서 제거하고 윈도우 축소
                winCounts.put(c, winCounts.get(c) - 1);
                // 줄였으니 유효성을 다시 검사함.
                // 만약 아래 winCounts 문자 빈도가 tCount 문자 빈도보다 작으면 formed 감소하고 while문 빠져나갈거임.
                if (tCount.containsKey(c) && winCounts.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }

                left++;
            }
        }
        // ans[0]이 -1이면, 유효한 윈도우를 못 찾은것이므로 빈 문자열 반환. 그렇지 않으면, s.substring으로 시작포인터, 끝 포인터 반환.
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    // 브루트 포스 -> 시간복잡도 O(pow(n, 2))
//    public String minWindow(String s, String t) {
//        // 슬라이딩 윈도우의 크기는 t의 크기부터 시작해서 점점 증가
//        for (int windowSize = t.length(); windowSize <= s.length(); windowSize++) {
//            // 해당 슬라이딩 윈도우로 전체 순회
//            for (int left = 0; left <= s.length() - windowSize; left++) {
//                // 윈도우 크기만큼 부분 문자열 생성
//                String sSubstr = s.substring(left, left + windowSize);
//
//                // 부분 문자열이 t를 포함하면 정답으로 리턴
//                if (contains(sSubstr, t))
//                    return sSubstr;
//            }
//        }
//        return "";
//    }
//
//    public boolean contains(String sSubstr, String t) {
//        // 문자열을 문자 단위로 편하게 처리하기 위해 StringBuilder로 변환
//        StringBuilder sb = new StringBuilder(sSubstr);
//        // t를 문자 단위로 반복
//        for (char tElem : t.toCharArray()) {
//            // t의 문자가 sb에 포함되어 있다면 삭제하면서 진행
//            if (sb.indexOf(String.valueOf(tElem)) != -1)
//                sb.deleteCharAt(sb.indexOf(String.valueOf(tElem)));
//            else
//                return false;
//        }
//        // 중간에 빠진 문자 없이 모든 문자가 삭제됐다면 true 리턴
//        return true;
//    }
}
