import node.BinaryTreeNode;

/**
 *  输入某二叉树的前序遍历和中序遍历的结果， 重建该二叉树。 假定二叉树中不含重复的数字
 *  例如 前序 {1,2,4,7,3,5,6,8} 中序 {4,7,2,1,5,3,8,6}
 *  重建二叉树并返回头节点
 *
 *  解法： 参考PAT 甲级1086题
 * @Author rowe
 * @Date 2020/1/22 11:15
 */
public class RebuildBinaryTree {

    public BinaryTreeNode rebuild(int[] pre, int[] in){
        if(pre == null || in == null || pre.length != in.length){
            return null;
        }

        int len = pre.length;
        return subBuild(pre, 0, len-1, in, 0, len-1);
    }

    private BinaryTreeNode subBuild(int[] pre, int pLeft, int pRight, int[] in, int iLeft, int iRight){
        if(pLeft > pRight) return null;
        BinaryTreeNode node = new BinaryTreeNode(pre[pLeft]);
        int i;
        for(i = iLeft; i <= iRight; ++i){
            if(in[i] == pre[pLeft]){
                break;
            }
        }
        int leftLength = i-iLeft;
        node.left = subBuild(pre, pLeft+1, pLeft+leftLength, in, iLeft, i-1);
        node.right = subBuild(pre, pLeft+leftLength+1, pRight, in, i+1, iRight);
        return node;
    }

    public static void main(String[] args) {
        int preOrder[] = {1,2,4,7,3,5,6,8};
        int inOrder[] = {4,7,2,1,5,3,8,6};

        BinaryTreeNode ans = new RebuildBinaryTree().rebuild(preOrder, inOrder);
        System.out.println(ans.value);

    }

}
