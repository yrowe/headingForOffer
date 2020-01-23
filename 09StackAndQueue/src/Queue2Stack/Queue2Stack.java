package Queue2Stack;

/**
 * 用两个队列模拟栈
 *
 * @Author rowe
 * @Date 2020/1/23 16:46
 */
public class Queue2Stack {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.add(1);
        customStack.add(2);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        customStack.add(3);
        System.out.println(customStack.pop());
    }
}
