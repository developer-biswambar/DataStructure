package Design;

import java.util.HashSet;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */

class RandomizedSet {

  private HashSet<Integer> set;

  public RandomizedSet() {
    set = new HashSet<>();

  }

  public boolean insert(int val) {
    return set.add(val);

  }

  public boolean remove(int val) {
    return set.remove(val);

  }

  public int getRandom() {

    int size = set.size();
    int item = new Random().nextInt(size);
    int i = 0;
    for(int obj : set)
    {
      if (i == item)
        return obj;
      i++;
    }

    return i;
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */