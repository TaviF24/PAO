package task2;

import java.util.*;

class MultiMapValue<K, V> {

    private HashMap<K,ArrayList<V>> map;

    public MultiMapValue(){
        map = new HashMap<>();
    }

    public void add(K key, V value) {
        if(map.containsKey(key)){
            map.get(key).add(value);
        }
        else{
            map.put(key,new ArrayList<>(){{
                add(value);
            }});
        }
    }

    public void addAll(K key, List<V> values) {
        if(map.containsKey(key)){
            map.get(key).addAll(values);
        }
        else{
            map.put(key,new ArrayList<>(){{
                addAll(values);
            }});
        }
    }

    public void addAll(MultiMapValue<K, V> map) {
        for(Map.Entry<K,ArrayList<V>>entry : map.map.entrySet()) {
            addAll(entry.getKey(),entry.getValue());
        }
    }

    public V getFirst(K key) {
        if(map.containsKey(key))
            return map.get(key).get(0);
        return null;
    }

    public List<V> getValues(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public List<V> remove(K key) {
        return map.remove(key);
    }

    public int size() {
        return map.size();
    }

}
