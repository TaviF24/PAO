package task3;

import java.util.HashSet;
import java.util.List;

class TreeImpl<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size=0;

    private void searchAndAdd(Node<T>root, T value){
        Node<T>next = root;
        if(root.getLeft()!=null && value.compareTo(root.getValue())<0){
            next = root.getLeft();
        }
        else if (root.getRight()!=null && value.compareTo(root.getValue())>0){
            next = root.getRight();
        }

        boolean found = false;
        while(!found){
            if(next.getLeft()!=null && value.compareTo(next.getValue())<0){
                next = next.getLeft();
            }
            else if (next.getRight()!=null && value.compareTo(next.getValue())>0){
                next = next.getRight();
            }else{
                found = true;
            }
        }

        if(value.compareTo(next.getValue())<0) {
            next.setLeft(new Node<>(value));
            size++;
        }
        else if (value.compareTo(next.getValue())>0) {
            next.setRight(new Node<>(value));
            size++;
        }
    }

    private void searchInRange(T inf, T sup, Node<T> node, HashSet<T> result) {
        if (node == null) {
            return;
        }

        if (node.getValue().compareTo(inf) >= 0 && node.getValue().compareTo(sup) <= 0) {
            result.add(node.getValue());
        }

        if (node.getValue().compareTo(inf) > 0) {
            searchInRange(inf, sup, node.getLeft(), result);
        }

        if (node.getValue().compareTo(sup) < 0) {
            searchInRange(inf, sup, node.getRight(), result);
        }
    }

    public TreeImpl(){
        root = null;
    }

    @Override
    public void addValue(T value) {
        if(root == null){
            root = new Node<>(value);
            size++;
        }else{
            searchAndAdd(root,value);
        }

    }

    @Override
    public void addAll(List<T> values) {
        for(T value : values){
            addValue(value);
        }
    }

    @Override
    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> hashSet = new HashSet<>();
        searchInRange(inf,sup,root,hashSet);
        return hashSet;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
