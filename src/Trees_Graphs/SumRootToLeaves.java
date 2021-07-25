package Trees_Graphs;

public class SumRootToLeaves {
    public int sumNumbers(TreeNode root) {
        return sumDFS(root, 0);
    }

    public int sumDFS(TreeNode root, int sum) {
        if (root==null) return 0;

        sum = sum * 10 + root.value; //this doesn't make the sum of the path-numbers, this only constructs the number
        // from the current path

        if(root.left == null && root.right == null)
            return sum;

        // now here we call dfs on left and right and SUM them (this is what does the sum of the paths)
        return sumDFS(root.left, sum) + sumDFS(root.right, sum);
    }
}
