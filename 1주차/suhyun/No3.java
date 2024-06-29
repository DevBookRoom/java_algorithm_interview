import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No3 {

    public static void main(String[] args) {

        SolutionNo3 solution = new SolutionNo3();
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        solution.reorderLogFiles(logs);
    }
}

class SolutionNo3 {
    public String[] reorderLogFiles(String[] logs) {

        List<String> digit = new ArrayList<>();
        List<String> letter = new ArrayList<>();

        for(String log : logs) {
            if(log.split(" ")[1].matches("[0-9]+"))
                digit.add(log);
            else
                letter.add(log);
        }
        Collections.sort(letter, (a, b) -> {
            String[] s1 = a.split(" ");
            String[] s2 = b.split(" ");

            int compared = s1[1].compareTo(s2[1]);
            if(compared == 0)
                compared = s1[2].compareTo(s2[2]);
            if(compared == 0)
                compared = s1.length - s2.length;
            return compared == 0 ? s1[0].compareTo(s2[0]) : compared;
        });

        letter.addAll(digit);
        return letter.toArray(new String[0]);
    }
}