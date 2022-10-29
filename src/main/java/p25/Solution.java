package p25;

import org.junit.Test;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode start = dummy.next, pre = dummy;
        int i = 0;
        boolean flag = true;
        while (flag && start != null) {
            flag = reverse(pre, start, k);
            pre = start;
            start = start.next;
        }
        return dummy.next;
    }
    public boolean reverse(ListNode p, ListNode head, int k) {
        ListNode pre = null, curr = head, init = head;
        ListNode temp = head;
        int i = 0;
        while(temp != null && i < k) {
            temp = temp.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            i++;
        }
        if (i != k) {
            reverse(p, pre, i);
            return false;
        }
        if (p != null)
            p.next = pre;
        init.next = temp;
        return true;
    }

    //头插法创建单链表  栈形式先进后出
    int i = 0;
    public void afterInsert(ListNode node,int data){

        if(i<=5){
            ListNode newNode=new ListNode();//创建新的结点
            newNode.data=i;//设置数据域
            newNode.next=node.next;
            node.next=newNode;
            afterInsert(node,++i);
        }

    }

    @Test
    public void test(){
        ListNode head = new ListNode();
        afterInsert(head, 0);
        ListNode result = reverseKGroup(head, 2);
        while(result.next!=null){
            result=result.next;
            System.out.print(result.data+" ");
        }

    }
}
