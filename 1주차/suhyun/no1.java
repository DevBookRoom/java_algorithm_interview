public class No1 {

  public static void main(String[] args) {

    Solution solution = new Solution();
    solution.isPalindrome(",; W;:GlG:;l ;,");
  }
}

class Solution {
  public boolean isPalindrome(String s) {

    boolean result = false;

    // 문장을 기호 빼고 공백 빼고 하나의 문자열로 만들기
    String resultString = changeString(s);

    // 대문자는 소문자로 변경
    resultString = resultString.toLowerCase();

    // 홀수인 경우 가운데 제거
    resultString = removeCenterChar(resultString);

    // 하나만 남거나 아무것도 없는 경우는 팬린드롬 처리
    if(resultString.length()==1 || resultString.length()==0){
      return true;
    }


    // 양끝에서 부터 같은지 확인
    for(int i = 0 ; i<resultString.length()/2 ; i++){
      if(resultString.charAt(i) == resultString.charAt(resultString.length()-1-i)){
        result = true;
      }else{
        result = false;
        break;
      }
    }

    return result;

  }

  // 정규 표현식으로 영문자 및 숫자만 남기기
  public String changeString(String s){
    return s.replaceAll("[^a-zA-Z0-9]", "");
  }

  // 문자열 길이가 홀수인 경우 가운데 문자 빼고 반환
  public String removeCenterChar(String s){
    StringBuffer sb = new StringBuffer();
    sb.append(s);
    if(s.length()%2!=0){

      sb.deleteCharAt(s.length()/2);
    }
    return sb.toString();
  }
}