//#1295
void main() {
    System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
}

public static int findNumbers(int[] nums) {
    int res = 0;
    for (int num : nums) {
        //my solution
//      String str = Integer.toString(num);
//      if (str.length() % 2 == 0) res++;
        //best solution
        int rem = 0;
        while (num > 0) {
            num = num / 10;
            rem++;
        }
        if (rem % 2 == 0) res++;
    }

    return res;
}