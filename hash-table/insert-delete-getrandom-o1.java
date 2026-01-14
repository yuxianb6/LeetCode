class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer>arr;


    public RandomizedSet() {
        map=new HashMap<>();
        arr=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val,arr.size());
            arr.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            arr.remove(map.get(val));
            map.remove(val);
            return true;
        }else{
            return false;
        }
        
    }
    
    public int getRandom() {
        int i = (int) (Math.random() * arr.size());
        return arr.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */