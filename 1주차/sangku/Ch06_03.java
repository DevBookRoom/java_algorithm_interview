package sangku;

import java.util.ArrayList;
import java.util.List;

public class Ch06_03 {

    String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isLetter(log.split(" ")[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((o1, o2) -> {
            var s1 = o1.split(" ", 2);
            var s2 = o2.split(" ", 2);

            return s1[1].equals(s2[1]) ? s1[0].compareTo(s2[0]) :s1[1].compareTo(s2[1]);
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}
