import java.util.*;

public class leetCode {
    public static void main(String[] args) {
        //#1295
//        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
        //#9
//        System.out.println(isPalindrome(121));
        //#66
//        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        //#1480
//        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        //929
//        System.out.println(numUniqueEmails(new String[]{
//                "test.email+alex@leetcode.com",
//                "test.e.mail+bob.cathy@leetcode.com",
//                "testemail+david@lee.tcode.com"}
//        ));
        //1
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        //2
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(2);
        ll.add(4);
        ll.add(3);
//        ListNode l1 = addNode(2, 4, 3);
//        ListNode l2 = addNode(5, 6, 4);
//        ListNode res = addTwoNumbers(ListNode l1, ListNode l2);
//        for (ListNode n : res)
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> newEmails = new HashSet<>();
        for (String email : emails) {
            //var1
//            String[] subStr = email.split("@");
//            subStr[0] = subStr[0].replaceAll("\\.", "");
//            int index = subStr[0].indexOf("+");
//            if (index > 0) {
//                subStr[0] = subStr[0].substring(0, index);
//            }
//            newEmails.add(subStr[0] + "@" + subStr[1]);
            //var2
            int atIndex = email.indexOf("@");
            int plusIndex = email.indexOf("+");
            String str1;
            if (plusIndex >= 0) str1 = email.substring(0, plusIndex);
            else str1 = email.substring(0, atIndex);
            str1 = str1.replaceAll("\\.", "") + email.substring(atIndex);
            newEmails.add(str1);
        }
        System.out.println(newEmails);
        return newEmails.size();
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

    public static int[] plusOne(int[] digits) {
        //my var
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
        //best var
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

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        //my var
//        boolean res = true;
//        char[] chars = Integer.toString(x).toCharArray();
//        for (int i = 0, j = chars.length-1; i < chars.length-1; i++, j--) {
//            if (chars[i] != chars[j]) {
//                res = false;
//                break;
//            }
//        }
//        return res;
        //best var
        int num = x;
        int rev = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            rev = rev * 10 + lastDigit;
            num = num / 10;
        }
        return rev == x;
    }

    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            //my var
//      String str = Integer.toString(num);
//      if (str.length() % 2 == 0) res++;
            //best var
            int rem = 0;
            while (num > 0) {
                num = num / 10;
                rem++;
            }
            if (rem % 2 == 0) res++;
        }
        //var2
        return res;
    }

    //1
    public static int[] twoSum(int[] nums, int target) {
        //my var
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
        //best var
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            int compl=target-nums[i];
//            if(map.containsKey(compl)){
//                return new int[]{map.get(compl),i};
//            }
//            map.put(nums[i],i);
//        }
//        return null;
    }

    //2
//     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }
}
