package findPath;

/**
 * 面试题12：  矩阵中的路径
 * 题目： 设计一个函数， 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。 路径可以从矩阵中的任意一格开始， 每一步
 * 可以在矩阵中向左右上下移动一格。 如果一条路径经过了矩阵的某一格， 那么该路径不能再次进入该格子。 例如， 在下面的3x4的矩阵中
 * 包含一条字符串"bfcd"的路径。 但矩阵中不包含字符串"abfb"的路径， 因为字符串的第一个字符b占据了矩阵中的第一行第二格之后，
 *  路径不能再次进入这个格子
 *
 *  [[a, b, t, g]
 *   [c, f, c, s]
 *   [j, d, e, h]]
 *
 * @Author rowe
 * @Date 2020/1/26 10:53
 */
public class FindPath {

    public Boolean find(Character[][] matrix, String target){
        if(matrix == null) return null;
        if(matrix.length == 0) return null;
        int height = matrix.length;
        if(matrix[0].length == 0) return null;
        int width = matrix[0].length;

        boolean[][] vis = new boolean[height][width];

        int x = 0, y = 0;
        for(y = 0; y < height; ++y){
            for(x = 0; x < width; ++x){
                if(hasPath(matrix, vis, y, x, height, width, target, 0)){
                    return true;
                }
            }
        }

        return false;

    }

    private boolean hasPath(Character[][] matrix, boolean[][] vis, int y, int x, int height, int width, String target, int len){
        if(len == target.length()){
            return true;
        }
        if((y>=0)&&(y<height)&&(x>=0)&&(x<width)&&(!vis[y][x])&&(matrix[y][x]==target.charAt(len))){
            vis[y][x] = true;
            if((hasPath(matrix, vis, y-1, x, height, width, target, len+1))
            ||(hasPath(matrix, vis, y+1, x, height, width, target, len+1))
            ||(hasPath(matrix, vis, y, x-1, height, width, target, len+1))
            ||(hasPath(matrix, vis, y, x+1, height, width, target, len+1))){
                return true;
            }else{
                vis[y][x] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindPath findPath = new FindPath();
        Character[][] matrix = {{'f','b','a','g'},{'c','f','c','s'}, {'j','b','e','h'}};
        String target = "abfb";
        System.out.println(findPath.find(matrix, target));
    }
}
