package amazon;

// http://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class

public class reverseList {
	private class ListNode {
		int val;
	    ListNode next;

	    ListNode(int x) { val = x; }

	}
	
	public ListNode reverseList1(ListNode head) {
        if(head == null) return null;
        //因為中間也需要變，所以要添加 dummy
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到中間的位置了slow 右側開始反轉
        ListNode pre = null;
        ListNode cur = slow.next;

        while(cur != null){
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre;
        return head;
    }
	
	public static void main(String[] args) {
        reverseList list = new reverseList();
        reverseList.ListNode one = list.new ListNode(1);
        reverseList.ListNode two = list.new ListNode(2);
        reverseList.ListNode three = list.new ListNode(3);
        reverseList.ListNode four = list.new ListNode(4);
        reverseList.ListNode five = list.new ListNode(5);
        //reverseList.ListNode six = list.new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        //five.next = six;
        ListNode o = one;
        System.out.println("Original : ");
        while(o != null){
            System.out.print(o.val+" ");
            o = o.next;
        }
        list.reverseList1(one);
        System.out.println("\nAfter : ");
        ListNode p = one;
        while(p != null){
            System.out.print(p.val+" ");
            p = p.next;
        }
    }

}
