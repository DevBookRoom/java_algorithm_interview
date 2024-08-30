class Solution {
    public int hammingDistance(int x, int y) {
        // XOR 연산 하면 다른 위치를 바로 찾을 수 있음. (문제에 대해 비트 자료형 한정)
        // 같으면 0, 다르면 1
        int xor = x ^ y;
        // bit로 환산했을 때, 값이 1인 자리의 개수.
        return Integer.bitCount(xor);
    }
}
