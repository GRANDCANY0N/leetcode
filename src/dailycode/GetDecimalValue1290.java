package dailycode;

/**
 * @author Canyon
 * @date 2025/07/14
 */
public class GetDecimalValue1290 {
    /**
     * @author Canyon
     * @date 2025/07/14
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
     }

    /**
     * sum维护最后的值，每次sum*2并加上链表的值直至链表遍历完整
     * @param head 链表，此链表是一个整数数字的二进制表示形式
     * @return int 该链表所表示数字的 十进制值
     */
    public int getDecimalValue(ListNode head) {
         int sum = 0;
         while(head.next!=null){
             sum = sum * 2 + head.val;
             head = head.next;
         }
         return sum;
    }
}
