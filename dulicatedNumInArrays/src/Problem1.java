/**
 * 题目1： 找出数组中重复的数字
 *  在一个长度为n的数组中的所有数字都在0~n-1的范围内， 数组中某些数字是重复的， 但不知道有几个数字重复了。
 *  也不知道每个数字重复了几次。 请找出数组中任意一个重复的数字。 例如如果输入长度为7的数组{2,3,1,0,2,5,3}
 *  那么对应的输出应该是数字2或者3
 *
 * 解法1: 对数组排序， 再扫描数组。    复杂度O(nlogn)
 * 解法2： 借助哈希表, 扫描一遍数组即可。   时间复杂度O（n）， 空间复杂度O(n)
 * 解法3： 不适用辅助数组且时间复杂度为O(n)的解法如下代码
 * @Author rowe
 * @Date 2020/1/12 15:53
 */
public class Problem1 {

    /**
     *
     * @param nums  待查询重复数字的数组
     * @param length  数组长度（java能直接从数组得到长度）
     * @return  -1表示无重复数字， 或输入不合法。 其余返回值即为查找到的重复数字
     */
    int duplicate(int[] nums, int length){
        if(nums == null || length <= 0){
            return -1;
        }

        for(int i = 0;i < length; ++i){
            if(nums[i] < 0 || nums[i] >= length){
                return -1;
            }
        }

        for(int i = 0;i < length; ++i){
            while(nums[i] != i){
                int m = nums[i];
                if(nums[i] == nums[m]){
                    return m;
                }
                int tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,0,2,5,3};
        System.out.println(new Problem1().duplicate(nums, nums.length));
    }
}
