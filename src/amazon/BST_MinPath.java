package amazon;

public class BST_MinPath {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int FindMin(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        if (root.left != null && root.right == null) {        	
        	return FindMin(root.left) + root.val;
        }
        if (root.left == null && root.right != null) {        	
        	return FindMin(root.right) + root.val;
        }
        return Math.min(FindMin(root.left), FindMin(root.right)) + root.val;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_MinPath bst = new BST_MinPath();
		
		BST_MinPath.TreeNode p1 = bst.new TreeNode(1);
		BST_MinPath.TreeNode p2 = bst.new TreeNode(6);
		BST_MinPath.TreeNode p3 = bst.new TreeNode(11);
		BST_MinPath.TreeNode p4 = bst.new TreeNode(8);
		BST_MinPath.TreeNode p5 = bst.new TreeNode(4);
		BST_MinPath.TreeNode p6 = bst.new TreeNode(2);
		BST_MinPath.TreeNode p7 = bst.new TreeNode(10);
		BST_MinPath.TreeNode p8 = bst.new TreeNode(5);
		BST_MinPath.TreeNode p9 = bst.new TreeNode(3);
		BST_MinPath.TreeNode p10 = bst.new TreeNode(7);
		BST_MinPath.TreeNode p11 = bst.new TreeNode(9);
		BST_MinPath.TreeNode p12 = bst.new TreeNode(12);
		
		p1.left = p2;   p1.right = p3;   p2.left = p4;   p2.right = p5;
		p3.left = p6;   p3.right = p7;   p4.left = p8;   p5.left = p9;
		p5.right = p10;   p6.right = p11;   p7.right = p12;
		
		System.out.println(bst.FindMin(p1));

	}

}
