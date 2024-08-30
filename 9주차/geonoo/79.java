class Solution {
    // UTF-8의 이진 포맷 -> 맨 앞 비트를 확인해서 0이면 1바이트, 10이면 특정 문자의 중간바이트, 110이면 2바이트, 1110이면 3바이트, 11110인 경우 4바이트
    public boolean validUtf8(int[] data) {
        int start = 0;
        // 문자 전체의 길이만큼 순회
        while (start < data.length) {
            // 문자의 시작 바이트
            int first = data[start];

            //11110으로 시작하면 나머지가 3바이트
            if (first >> 3 == 0b11110 && check(data, start, 3)) {
                start += 4;

                // 1110으로 시작하면 나머지가 2바이트
            } else if (first >> 4 == 0b1110 && check(data, start, 2)) {
                start += 3;

                // 110으로 시작하면 나머지가 1바이트
            } else if (first >> 5 == 0b110 && check(data, start, 1)) {
                start += 2;

                // 1바이트 문자
            } else if (first >> 7 == 0) {
                start++;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean check(int[] data, int start, int size) {
        // size 만큼 이동하면서 각 바이트 10으로 시작 여부 확인
        for (int i = start + 1; i < start + size + 1; i++) {
            if (i >= data.length || data[i] >> 6 != 0b10) {
                return false;
            }
        }
        return true;
    }
}
