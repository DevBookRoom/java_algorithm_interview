package sangku;

class Ch06_02 {
    void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            var temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
