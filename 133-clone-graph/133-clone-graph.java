/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        
        while(!queue.isEmpty()){
            Node rn = queue.remove();
            Node cn = map.get(rn); // get the cloned node for current node
            for(Node nbr : rn.neighbors){
                if(map.containsKey(nbr)){
                    cn.neighbors.add(map.get(nbr));
                    continue;
                }
                
                Node nn = new Node(nbr.val);
                cn.neighbors.add(nn);
                map.put(nbr, nn);
                queue.add(nbr);
            }
        }
        
        return map.get(node);
    }
}