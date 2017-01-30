// Given a binary tree, determine if it is a valid binary search tree (BST).
// Assume a BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class ValidBST 
{
    public boolean isValidBST(TreeNode root) 
    {
        // edge case
        if (root == null)
            return true;
        
        // check if maximum left-subtree value is less than root value
        if (root.left != null)
        {
            TreeNode maxLeft = root.left;
            while (maxLeft.right != null)
                maxLeft = maxLeft.right;
            if (maxLeft.val >= root.val)
                return false;
        }
        
        // check if minimum right-subtree value is bigger than root value
        if (root.right != null)
        {
            TreeNode minRight = root.right;
            while (minRight.left != null)
                minRight = minRight.left;
            if (minRight.val <= root.val)
                return false;
        }
        
        // recursively check the two subtrees
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
