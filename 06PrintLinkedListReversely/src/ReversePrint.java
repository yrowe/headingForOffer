import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * 题目： 输入一个链表的头节点， 从尾到头反过来打印每个节点的值。
 *
 * 解法: 遍历链表， 值用栈暂存。 再输出即可实现逆序。
 *
 * @Author rowe
 * @Date 2020/1/15 17:55
 */
public class ReversePrint {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

     private void print(ListNode p){
         Stack<Integer> s = new Stack<Integer>();
         while(p != null){
             s.push(p.val);
             p = p.next;
         }
         while(!s.empty()){
             System.out.println(s.pop());
         }
     }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = null;

        new ReversePrint().print(p);
    }
}
