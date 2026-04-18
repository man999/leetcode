//#66
void main() {
    System.out.println(Arrays.toString(plusOne(new int[]{9})));
}

public static int[] plusOne(int[] digits) {
    //my solution
//        int step = 1;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            int num = digits[i] + step;
//            if (num > 9) {
//                step = num - 9;
//                num = 0;
//            } else {
//                step = 0;
//            }
//            digits[i] = num;
//        }
//        if (step > 0) {
//            digits = new int[digits.length + 1];
//            digits[0] = step;
//        }
//        return digits;
    //best solution
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] == 9) {
            digits[i] = 0;
        } else {
            digits[i]++;
            return digits;
        }
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
}
