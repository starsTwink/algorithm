package com.ghx.math.study;

/**
 * @author：ghx
 * @date：2020/5/6 21:52
 * @describe：重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 前序遍历序列[1, 2, 3, 4, 5, 6, 7]
 * 中序遍历序列[3,2,4,1,6,5,7]
 * 结果集：{1,2,5,3,4,6,7}
 *      1
 *   2    5
 * 3  4  6 7
 */
public class BinaryTree {
    /*
    思路：
    采用递归的方法就可以了，原理很简单。
    分出了左右子树之后再分别对左右两边采用递归。
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);//前序的第一个数定为根
        int len = pre.length;
        //当只有一个数的时候
        if (len == 1) {
            root.left = null;
            root.right = null;
            return root;
        }
        //找到中序中的根位置
        int data = root.val;
        int i;
        for (i = 0; i < len; i++) {
            if (data == in[i])
                break;
        }
        //创建左子树
        if (i > 0) {
            int[] pr = new int[i];
            int[] ino = new int[i];
            for (int j = 0; j < i; j++) {
                pr[j] = pre[j + 1];
            }
            for (int j = 0; j < i; j++) {
                ino[j] = in[j];
            }
            root.left = reConstructBinaryTree(pr, ino);
        } else {
            root.left = null;
        }
        //创建右子树
        if (len - i - 1 > 0) {
            int[] pr = new int[len - i - 1];
            int[] ino = new int[len - i - 1];
            for (int j = i + 1; j < len; j++) {
                ino[j - i - 1] = in[j];
                pr[j - i - 1] = pre[j];
            }
            root.right = reConstructBinaryTree(pr, ino);
        } else {
            root.right = null;
        }


        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in  =new int[]{3, 2, 4, 1, 6, 5, 7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }
}
