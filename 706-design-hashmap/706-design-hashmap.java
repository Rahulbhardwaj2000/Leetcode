class MyHashMap {
    
    ArrayList<Pair>[] map;
    int size;

    public MyHashMap() {
        size = 1000;
        map = new ArrayList[size];
    }
    
    public void put(int key, int value) {
        int hash = key%size;
        ArrayList<Pair> list = map[hash];
        if(list == null){
            map[hash] = new ArrayList();
            map[hash].add(new Pair(key, value));
            return;
        }
        
        int flag = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).key == key){
                list.get(i).val = value;
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            list.add(new Pair(key, value));
        }
    }
    
    public int get(int key) {
        int hash = key%size;
        ArrayList<Pair> list = map[hash];
        if(list == null) return -1;
        
        for(int i=0;i<list.size();i++){
            if(list.get(i).key == key){
                return list.get(i).val;
            }
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int hash = key%size;
        ArrayList<Pair> list = map[hash];
        if(list == null) return;
        
        int flag = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).key == key){
                list.remove(i);
            }
        }
    }
}

class Pair {
    int key;
    int val;
    
    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */