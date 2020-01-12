/**
 *  （本题不看!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!！）
 * 在题目1的基础上增加不得修改原数组的要求。 注： 数组值范围变为1~n， 长度为n+1
 *
 * 解法1： 哈希表。 时间复杂度O(n) 空间复杂度O(n)
 * 解法2： 时间O(nlogn)， 空间O(1)如下代码
 *
 * @Author rowe
 * @Date 2020/1/12 16:26
 */
public class Problem2 {

    /**
     *
     * @param nums 待查询重复数字的数组
     * @return -1表示无重复或输入不合法， 其余返回即为重复值
     */
    int duplicated(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        for(int i = 0;i < length; ++i){
            if(nums[i] <= 0 || nums[i] >= length){
                return -1;
            }
        }
        int start = 1, end = length-1;
        while(start <= end){
            int middle = (start + end)/2;
            int cnt = count(nums, start, middle);
            if(start == end){
                if(cnt > 1) return start;
                else break;
            }
            if(cnt > (middle-start+1)){
                end = middle;
            }else{
                start = middle+1;
            }
        }
        return -1;
    }

    int count(int[] nums, int start, int end){
        int cnt = 0;
        for(int i = 0;i < nums.length; ++i){
            if(nums[i] >= start && nums[i] <= end){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,4,8,2,6,7};           // 本方法缺陷， 本例无法识别会返回2。
        System.out.println(new Problem2().duplicated(nums));
    }
}
