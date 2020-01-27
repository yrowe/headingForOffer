package Find;

/**
 *  题目： 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之为数组的旋转。 输入一个递增排序的数组的一个旋转，
 *  输出旋转数组的最小元素。 例如， 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转。 该数组的最小值为1
 *
 * 解法： 三种情况
 * 1. 右端<左端 <中端     找右边
 * 2. 左 < 中 < 右       找左边
 * 3. 中 < 右 < 左       找左边
 *  考虑到， left = mid + 1, right = mid -1 需要考虑中值是不是最小值， 统一放到最后的判单。
 *
 * @Author rowe
 * @Date 2020/1/25 17:01
 */

//TODO: 测试样例补全， 找旋转数组特定值（leetcode题号）
public class FindMin {

    public Integer find(int[] num){
        int right = num.length-1, left = 0;
        while((left != right) && (right != left+1)){
            int mid = (left+right)/2;
            if((num[right] < num[left])&&(num[left] < num[mid])){
                left = mid;  //找右边
            }else{
                right = mid; // 找左边
            }
        }

        if(left == right) return num[left];
        else{
            return Math.min(num[left], num[right]);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,1};   //{1,2,3}, {2,3,1}, {2,1}
        FindMin aa = new FindMin();
        System.out.println(aa.find(num));
    }
}
