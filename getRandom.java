class RandomizedSet {
    
    HashMap<Integer,Integer> hm; //to store val and corresponding index in arraylist
    List<Integer> al; //to get random value
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap();
        al = new ArrayList();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val))
            return false;
        else{
            al.add(val);
            hm.put(val,al.size()-1);
        }
        return true;
    }
    
    //we swap val with last element and then remove last element to achieve O(1) time
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int last = al.get(al.size()-1);
            int indexOfRemoveElement = hm.get(val);
            al.set(indexOfRemoveElement,last);
            al.remove(al.size()-1);
            //update hashmap
            hm.put(last,indexOfRemoveElement);
            hm.remove(val);
            return true;
        } else
            return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int getIndex = (int)(Math.random()*al.size());
        return al.get(getIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
