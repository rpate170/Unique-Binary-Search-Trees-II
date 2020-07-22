/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
        return new ArrayList<TreeNode>();
        }
        return generateBST(1, n);
    }
    
    public List<TreeNode> generateBST(int start, int end) {
        System.out.println("Start: " + start + " End: " + end);
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSub = generateBST(start, i-1);
            List<TreeNode> rightSub = generateBST(i+1, end);
            
            for (TreeNode left : leftSub) {
                for (TreeNode right : rightSub) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}