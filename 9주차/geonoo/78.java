import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int getSum(int x, int y) {
        // 전가산기 : 전가산기는 피연산수 X와 연산수 Y 그리고 하위비트에서 발생한 올림수 Cin을 입력받아 이 세 수의 합인 S와 올림수 Cout을 출력하는 회로.
        // 진리표를 논리식으로 바꾸는 방법은 출력이 1이 나오는 값의 입력들을 AND연산한 후 그 결과값들을 OR연산 하면 된다.
        // 정수형을 32비트 2진수 문자열로 변환
        String binX = String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0');
        String binY = String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0');

        List<Character> result = new ArrayList<>();
        int carry = 0;  // 올림수
        int sum = 0;

        // 32비트 모든 자리를 뒤에서부터 계산
        for (int i = 0; i < 32; i++) {
            // 뒤에서부터 비트값을 정수형으로 추출
            int X = Character.getNumericValue(binX.charAt(31 - i));
            int Y = Character.getNumericValue(binY.charAt(31 - i));

            // 전가산기 구현
            int Q1 = X & Y;
            int Q2 = X ^ Y;
            int Q3 = Q2 & carry;
            sum = carry ^ Q2;
            carry = Q1 | Q3;

            // int를 Character로 변환하여 리스트 앞쪽으로 추가
            // radix : 기수. radix: 2 -> 0과 1, radix: 10 -> 0~9까지의 수
            result.add(0, Character.forDigit(sum, 2));
        }

        // 2진수 문자열을 정수형으로 변환하여 리턴
        return Integer.parseUnsignedInt(
                result.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("")), 2
        );
    }
}
