//#2
void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode ln = new ListNode(4);
    l1.next = ln;
    ListNode last = ln;
    ln = new ListNode(3);
    last.next = ln;

    ListNode l2 = new ListNode(5);
    ln = new ListNode(6);
    l2.next = ln;
    last = ln;
    ln = new ListNode(4);
    last.next = ln;

    ListNode res = addTwoNumbers(l1, l2);
    System.out.println(res.toString());
}

public static class ListNode {
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //best solution
    ListNode sumList = new ListNode(-1);
    ListNode curr = sumList;
    ListNode t1 = l1;
    ListNode t2 = l2;
    int carry = 0;

    while (t1 != null || t2 != null) {
        int sum = carry;
        if (t1 != null) {
            sum = sum + t1.val;
            t1 = t1.next;
        }
        if (t2 != null) {
            sum = sum + t2.val;
            t2 = t2.next;
        }

        ListNode val = new ListNode(sum % 10);
        curr.next = val;
        curr = curr.next;
        carry = sum / 10;
    }

    if (carry > 0) {
        ListNode val = new ListNode(carry);
        curr.next = val;
    }

    return sumList.next;
}