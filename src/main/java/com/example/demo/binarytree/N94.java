package com.example.demo.binarytree;

//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 644 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/8/28 14:56
 * @Author: tianlg
 */
public class N94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversal(root, result);
        return result;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, result);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(2);
        a.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(a);
        list.forEach(str -> {
            System.out.println(str);
        });
    }
}
