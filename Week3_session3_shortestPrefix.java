class TrieNode {
    public TrieNode [] child;
    public Boolean isLeaf = false;
    public int freq = 1;
    
    TrieNode(){
        this.child = new TrieNode [26];
        for(int i =0 ; i< this.child.length; i++){
            this.child[i] = null;
        }
    }
}


public class Solution {
    public ArrayList<String> prefix(ArrayList<String> a) {
        TrieNode root = new TrieNode();
        ArrayList<String> res = new ArrayList<String>();
        
        for(int i=0; i< a.size(); i++){
            TrieNode ptr = root;
            String s = a.get(i);
            for(int j=0 ; j< s.length(); j++){
                char c = s.charAt(j);
                int index = (int)c - (int)'a';
                if (ptr.child[index] == null) {
                    ptr.child[index] = new TrieNode();
                } else {
                    ptr.child[index].freq ++;
                }
                ptr = ptr.child[index];
            }
            ptr.isLeaf = true;
        }
        
        for(int i=0; i<a.size();i++){
            TrieNode ptr = root;
            StringBuilder str = new StringBuilder();
            String s = a.get(i);
            for(int j=0; j< s.length(); j++) {
                char c = s.charAt(j);
                int index = (int)c - (int)'a';
                str.append(c);
                if(ptr.child[index].freq == 1){
                    res.add(str.toString());
                    break;
                } 
                ptr = ptr.child[index];
            }
        }
        return res;
    }
}
