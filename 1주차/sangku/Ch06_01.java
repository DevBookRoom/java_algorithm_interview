package sangku;

class Ch06_01 {
    boolean isPalindrome(String s) {
        var text = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}