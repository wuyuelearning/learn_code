package other.test;

/**
 * Created by wuyue on 2020/12/29.
 */
public class ListNodeTest {
    public static void main(String[] args) {
        ListNode n1 =new ListNode(1);
        ListNode n2 =new ListNode(2);
        ListNode n3 =new ListNode(3);
        System.out.println(n2.toString());
        n1.next =n2;
        n2.next=n3;

        ListNode nn =new ListNode(11);
        nn =n1.next;
        n2.val=100;
        System.out.println(nn.val);
    }
}
