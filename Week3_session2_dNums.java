public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        
        int n = A.size();
        if (B > n ) return null;
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        ArrayList <Integer> res = new ArrayList<Integer>();
        int key = A.get(0);
        for(int i=0; i< B ; i++) {
            if(!hm.containsKey(A.get(i))){
                hm.put(A.get(i),1);
            }else {
                hm.put(A.get(i),hm.get(A.get(i))+1);
            }
        }
        res.add(hm.keySet().size());
        
        for (int i = 1 ; (i + B -1 ) < n ; i++){
            int k = hm.get(key);
            k = k-1;
            if(k==0){
                hm.remove(key);
            } else {
                hm.put(key,k);
            }
            
            key = A.get(i);
            
            
            if(!hm.containsKey(A.get(i+B-1))){
                hm.put(A.get(i+B-1),1);
            }else {
                hm.put(A.get(i+B-1),hm.get(A.get(i+B-1))+1);
            }
            res.add(hm.keySet().size());
            
        }
        return res;
    }
}
