//#9
void main() {
    System.out.println(isPalindrome(121));
}

public static boolean isPalindrome(int x) {
    if (x < 0) return false;
    //my solution
//        boolean res = true;
//        char[] chars = Integer.toString(x).toCharArray();
//        for (int i = 0, j = chars.length-1; i < chars.length-1; i++, j--) {
//            if (chars[i] != chars[j]) {
//                res = false;
//                break;
//            }
//        }
//        return res;
    //best solution
    int num = x;
    int rev = 0;
    while (num != 0) {
        int lastDigit = num % 10;
        rev = rev * 10 + lastDigit;
        num = num / 10;
    }
    return rev == x;
}