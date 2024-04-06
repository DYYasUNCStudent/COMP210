package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;

    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO (Task 2A): enqueue
    public void enqueue(V value) {
        Prioritized<V, P> new_PA = new Patient(value);
        this._heap.add(new_PA);
        bubbleUp(this._heap.size() - 1);
    }
    int bubbleUp(int index){
        if (index == 0){
            return(index);
        }
        else{
            Prioritized<V, P> child = _heap.get(index);
            Prioritized<V, P> parent = _heap.get(parentInd(index));
            if (child.getPriority().compareTo(parent.getPriority()) > 0){
                _heap.set(parentInd(index), child);
                _heap.set(index, parent);
                return bubbleUp(parentInd(index));
            }
            else{
                return(index);
            }
        }
    }
    static int leftChildInd(int index){
        return (2*index +1);
    }
    static int rightChildInd(int index){
        return (2*index +2);
    }
    static int parentInd(int index){
        return ((index-1) /2);
    }
    // TODO (Task 2A): enqueue
    @Override
    public void enqueue(V value, P priority) {
        Prioritized<V, P> new_PA = new Patient(value, priority);
        this._heap.add(new_PA);
        bubbleUp(this._heap.size() - 1);
    }
    // TODO (Task 2A): dequeue
    @Override
    public V dequeue() {
        if(_heap.isEmpty()){
            return null;
        } else if (_heap.size() == 1) {
            V value = _heap.get(0).getValue();
            _heap.remove(0);
            return value;
        } else {
            Prioritized<V, P> levPA = _heap.get(0);
            _heap.set(0, _heap.remove(_heap.size() - 1));
            bubbleDown(0);
            return levPA.getValue();
        }
    }
    int bubbleDown(int index){
        Prioritized<V, P> parent = _heap.get(index);
        if (!hasLeftChild(index) && !hasRightChild(index)){
            return(index);
        } else if (!hasRightChild(index)) {
            Prioritized<V, P> child = _heap.get(leftChildInd(index));
            if(parent.getPriority().compareTo(child.getPriority()) < 0){
                _heap.set(index, child);
                _heap.set(leftChildInd(index), parent);
                return(bubbleDown(leftChildInd(index)));
            }
            else {
                return (index);
            }
        } else if (!hasLeftChild(index)) {
                Prioritized<V, P> child = _heap.get(rightChildInd(index));
                if(parent.getPriority().compareTo(child.getPriority()) < 0){
                    _heap.set(index, child);
                    _heap.set(rightChildInd(index), parent);
                    return(bubbleDown(rightChildInd(index)));
                }
                else {
                    return (index);
                }
            // 2 children
        } else {
            Prioritized<V, P> leftChild = _heap.get(leftChildInd(index));
            Prioritized<V, P> rightChild = _heap.get(rightChildInd(index));
            int largeChildInd = 0;
            if (rightChild.getPriority().compareTo(leftChild.getPriority()) > 0){
                largeChildInd = rightChildInd(index);
            } else {
                largeChildInd = leftChildInd(index);
            }
            if (parent.getPriority().compareTo(_heap.get(largeChildInd).getPriority()) < 0) {
                _heap.set(index, _heap.get(largeChildInd));
                _heap.set(largeChildInd, parent);
                return (bubbleDown(largeChildInd));
            }
        }
        return (index);
    }


     public boolean hasLeftChild(int index){
        if (leftChildInd(index) > _heap.size() - 1){
            return false;
        } else {
            return true;
        }
    }
     public boolean hasRightChild(int index){
        if (rightChildInd(index) > _heap.size() - 1){
            return false;
        } else {
            return true;
        }
    }
    // TODO (Task 2A): getMax
    @Override
    public V getMax() {
    	if (_heap.isEmpty()){
            return null;
        } else{
            return _heap.get(0).getValue();
        }
    }

    // TODO (part 2B) : updatePriority
    public void updatePriority(V value, P newPriority) {
        int patientInd = -1;
        for (int i = 0; i < _heap.size(); i++) {
            if (_heap.get(i).getValue().equals(value)) {
                patientInd = i;
            }
        }
        if (patientInd == -1){
            return;
        } else {
            P oldP = _heap.get(patientInd).getPriority();
            Prioritized<V, P> new_PA = new Patient(value, newPriority);
            _heap.set(patientInd, new_PA);
            if(oldP.compareTo(newPriority) > 0){
                bubbleDown(patientInd);
            } else if (oldP.compareTo(newPriority) < 0) {
                bubbleUp(patientInd);
            }
        }
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Task 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = new ArrayList<>();
        for (int i = 0; i < initialEntries.length; i++){
            _heap.add(initialEntries[i]);
        }
        int lastIndex = this._heap.size() - 1;
        int lastParentIndex = (lastIndex - 1) / 2;
        for (int i = lastParentIndex; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }
}
