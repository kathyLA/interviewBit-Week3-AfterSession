public ListNode mergeKLists(ArrayList<ListNode> a) {
//queue.pull
if (a == null) return null;

    PriorityQueue<ListNode> prq = new PriorityQueue<ListNode>(10, new ListNodeComparator());
    for(ListNode node: a){
        prq.add(node);
    }
    if (prq.isEmpty()) return null;

    ListNode current = prq.poll();

    if(current.next != null){
        prq.add(current.next);
    }
    ListNode head = current;
    while(!prq.isEmpty()){
        ListNode node = prq.poll();
        if(node.next!=null) {
            prq.add(node.next);
            node.next = null;
        }
        current.next = node;
        current = current.next;

    }
    return head;
}

public class ListNodeComparator implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b){
        return Integer.compare(a.val,b.val);
    }
}
}
