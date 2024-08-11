import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Number61 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        String alpha = "";
        int num = 0;

        for (String str : operations) {
            Collections.sort(list);
            alpha = str.split(" ")[0];
            num = Integer.parseInt(str.split(" ")[1]);
            if (alpha.equals("I")) {
                list.add(num);
            } else if (alpha.equals("D") && num == 1 && !list.isEmpty()) {
                list.remove(list.size() - 1);
            } else if (alpha.equals("D") && num == -1 && !list.isEmpty()) {
                list.remove(0);
            }
        }
        Collections.sort(list);
        if (list.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }

        return answer;
    }

}