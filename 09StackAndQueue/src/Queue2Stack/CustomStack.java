package Queue2Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 和用栈模拟队列略有不同， 本题思路是， 利用两个栈， add数据时， 只向已有数据的队列添加
 * pop时， 将已有数据的那个队列全部迁移至空队列去， 当清到最后一个数据时， 即为要输出的数据
 *
 * @Author rowe
 * @Date 2020/1/23 16:46
 */
public class CustomStack {
    private Queue<Integer> q1, q2;

    public CustomStack(){
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void add(Integer value){
        if(q1.isEmpty()){
            q2.add(value);
        }else{
            q1.add(value);
        }
    }

    public Integer pop(){
         if(q1.isEmpty()){
             while(!q2.isEmpty()){
                 Integer tmp = q2.poll();
                 if(q2.isEmpty()){
                     return tmp;
                 }else{
                     q1.add(tmp);
                 }
             }

         }
         else{
             while(!q1.isEmpty()){
                 Integer tmp = q1.poll();
                 if(q1.isEmpty()){
                     // 是非空队列的最后一个元素了
                     return tmp;
                 }else{
                     q2.add(tmp);
                 }
             }
         }
         return null;
    }
}
