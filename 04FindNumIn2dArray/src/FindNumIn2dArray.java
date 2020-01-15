/**
 * 题目： 在一个二维数组中， 每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数， 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * 解法： 始终定位右上角（行值0， 列值col-1）。
 *       如果该数字大于要查找的数字， 则剔除这个数字所在的列（列值-1）
 *       如果该数字小于要查找的数字， 则剔除这个数字所在的行（行值+1）
 *
 * @Author rowe
 * @Date 2020/1/13 17:02
 */
public class FindNumIn2dArray {

    public boolean find(int[][] matrix, int num){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int height = matrix.length, width = matrix[0].length;

        int curHeight = 0, curWidth = width-1;    //从右上角开始.
        while(curHeight < height && curWidth >= 0){
            if(matrix[curHeight][curWidth] == num){
                return true;
            }
            if(matrix[curHeight][curWidth] > num){
                curWidth--;
            }else{
                curHeight++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new FindNumIn2dArray().find(arr, 5));
    }
}
