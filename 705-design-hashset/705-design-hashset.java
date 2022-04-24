class MyHashSet {
    
    ArrayList<Integer>[] set;
    int size;

    public MyHashSet() {
        size = 1000;
        set = new ArrayList[size];
    }
    
    public void add(int key) {
        int hash = key%size;
        ArrayList<Integer> list = set[hash];
        if(list == null){
            set[hash] = new ArrayList<>();
            set[hash].add(key);
            return;
        }
        if(!list.contains(key)){
            list.add(key);
        }
    }
    
    public void remove(int key) {
        int hash = key%size;
        ArrayList<Integer> list = set[hash];
        if(list == null) return;
        
        if(contains(key)){
            list.remove(new Integer(key));
        }
    }
    
    public boolean contains(int key) {
        int hash = key%size;
        ArrayList<Integer> list = set[hash];
        if(list == null) return false;
        if(list.contains(key)) return true;
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */