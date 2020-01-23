package Stack2Queue;

import java.util.Stack;

/**
 * 类功能描述
 *
 * @Author rowe
 * @Date 2020/1/23 16:19
 */
public class CustomQueue {
    private Stack<Integer> s1, s2;
    public CustomQueue(){
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void appendTail(Integer value){
        s1.add(value);
    }

    public Integer deleteHead(){
        if(!s2.empty()){
            // s2本来不为空
            return s2.pop();
        }else{
            // s2本身为空， 将s1值倒入s2
            while(!s1.empty()){
                s2.add(s1.pop());
            }
            if(!s2.empty()){
                return s2.pop();
            }
        }
        // s1和s2都是空
        return -1;
    }

}
