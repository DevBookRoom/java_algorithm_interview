public class No2 {

  public static void main(String[] args) {

    SolutionNo2 solution = new SolutionNo2();
    String str = "HELLO";
    char[] s = str.toCharArray();
    solution.reverseString(s);
  }
}

class SolutionNo2 {
  public void reverseString(char[] s) {

    char[] result = new char[s.length];
    int cnt = 0;

    for(int i = s.length-1 ; i>=0 ; i--){
      result[cnt] = s[i];
      cnt++;
    }

    s=result;


    // 왜 reverse 넣었는데 제출하면 안 바뀌냐;;
    String str = String.valueOf(s);
    StringBuilder sb = new StringBuilder(str);
    String reverseStr = sb.reverse().toString();

    s = reverseStr.toCharArray();
    System.out.println(s);
  }
}