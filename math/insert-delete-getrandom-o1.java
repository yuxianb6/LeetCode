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
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        int lastVal = arr.get(arr.size() - 1);

        // 1. 用最后一个元素覆盖 idx 位置
        arr.set(idx, lastVal);
        map.put(lastVal, idx);

        // 2. 删除最后一个元素
        arr.remove(arr.size() - 1);
        map.remove(val);

        return true;
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