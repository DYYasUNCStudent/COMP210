package assn05;

import java.util.Random;

public class Patient<V, Integer extends Comparable<Integer>> implements Prioritized<V, Integer> {
    private Integer priority;
    private V value;


    public Patient(V value, Integer priority) {
        this.value = value;
        this.priority = priority;
    }

    public Patient(V value) {
        this.value = value;
        calculatePriority();
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public Integer getPriority() { return priority; }

    private void calculatePriority() {
        Random random = new Random();
        this.priority = (Integer) new java.lang.Integer(random.nextInt(1000000));
    }
    
    public int compareTo(Prioritized<V, Integer> other) {
    	return this.priority.compareTo(other.getPriority());
    }
}
