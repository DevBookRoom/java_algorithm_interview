import java.util.*;
public class No4 {

    public static void main(String[] args) {
        SolutionNo4 solutionNo4 = new SolutionNo4();
        solutionNo4.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"});
    }
}
class SolutionNo4 {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 금지 문자 리스트 생성
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));

        // 입력 문자 리스트 처리
        // \\W 영문자,숫자 제외한 모든 문자열을 뜻함
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Integer> cnt= new HashMap<>();
        // 개수 세기
        for (String w : words) {
            if (!banSet.contains(w)) {
                // 해당 단어가 맵에 존재하면 그 키의 값을 반환 , 없으면 0반환 즉 있는 친구면 계속올라가고 처음이면 1부터 시작
                cnt.put(w, cnt.getOrDefault(w, 0) + 1);
            }
        }
        return Collections.max(cnt.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}