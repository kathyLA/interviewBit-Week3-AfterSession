class Index {
    int index = 0;
}
public class Solution {
    TreeNode recBuildTree(ArrayList<Integer> in, ArrayList<Integer>post, int s, int e, Index p){
        if(s > e){
            return null;
        }
        
        TreeNode node = new TreeNode(post.get(p.index));
        node.left = null;
        node.right = null;
        p.index --;
        
        if(s == e){
            return node;
        }
        
        int i = in.indexOf(node.val);
        node.right = recBuildTree(in,post,i+1,e,p);
        node.left = recBuildTree(in,post,s,i-1,p);
        
        return node;
    }
    
    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        Index p = new Index();
        p.index = postorder.size() -1;
        return  recBuildTree(inorder,postorder,0,postorder.size()-1,p);
    }
}
