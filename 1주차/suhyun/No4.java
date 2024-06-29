import java.util.*;
public class No4 {

    public static void main(String[] args) {

    }
}
class SolutionNo4 {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 금지 문자 리스트 생성
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        // 입력 문자 리스트 처리
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Integer> cnt= new HashMap<>();
        // 개수 세기
        for (String w : words) {
            if (!banSet.contains(w)) {
                cnt.put(w, cnt.getOrDefault(w, 0) + 1);
            }
        }
        return Collections.max(cnt.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}