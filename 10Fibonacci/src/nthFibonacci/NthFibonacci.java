package nthFibonacci;

/**
 * 题目一： 求斐波那契数列的第n项
 *
 * 解法： 无额外空间开销， 时间复杂度为O(n)
 *
 * @Author rowe
 * @Date 2020/1/25 16:34
 */
public class NthFibonacci {

    public Integer compute(int n){
        if(n < 0){
            return null;
        }else if(n < 2){
            return n==0?0:1;
        }else{
            int ans = 0, fib1 = 0, fib2 = 1;
            for(int i = 2;i <= n; ++i){
                ans = fib1 + fib2;
                fib1 = fib2;
                fib2 = ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        NthFibonacci nthFibonacci = new NthFibonacci();
        System.out.println(nthFibonacci.compute(6));
    }
}
