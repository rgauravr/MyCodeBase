/*

https://leetcode.com/problems/find-all-the-lonely-nodes/

In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.

Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
 */


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LonelyNode1469 {

    List<Integer> list = new ArrayList<>();

    public void preOrder(TreeNode root){
        if(root == null)
            return;

        if((root.left!=null && root.right==null) || (root.left==null && root.right!=null)){
            if(root.left!=null)
                list.add(root.left.val);
            else
                list.add(root.right.val);
        }
        preOrder(root.left);
        preOrder(root.right);
    }
    public List<Integer> getLonelyNodes(TreeNode root) {
        preOrder(root);
        return list;

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1,null,null);
        root.left=new TreeNode(1,null,null);
        root.right=new TreeNode(4,null,null);
        root.left.left=new TreeNode(6,null,null);
        root.right.left=new TreeNode(5,null,null);
        root.right.right = new TreeNode(3,null,new TreeNode(2,null,null));
        LonelyNode1469 obj = new LonelyNode1469();
        obj.getLonelyNodes(root);
        System.out.println(obj.list);
    }
}
