package Stack2Queue;

/**
 * 题目： 用两个栈实现一个队列。 队列的声明如下， 请实现它的两个函数appendTail和deleteHead。
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 *
 * @Author rowe
 * @Date 2020/1/23 16:18
 */
public class Stack2Queue {


    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        customQueue.appendTail(1);
        customQueue.appendTail(2);
        System.out.println(customQueue.deleteHead());
        customQueue.appendTail(3);
        System.out.println(customQueue.deleteHead());
        System.out.println(customQueue.deleteHead());
    }

}
