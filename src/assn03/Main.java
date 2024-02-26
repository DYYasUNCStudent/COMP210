package assn03;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(60);
        list.add(30);
        System.out.println("list = " + list.toString());
        System.out.println("size of list = " + list.size());
        System.out.println("list contains 10?: " + list.contains(10));     // implemented
        System.out.println("list contains 50?: " + list.contains(50));
        System.out.println("set element at index 2 to be 10");
        list.set(2, 10);
        System.out.println("get element at index 2 = " + list.get(2));
        System.out.println("list = " + list.toString());
        System.out.println("Last Index of element 10 in list = " + list.lastIndexOf(10));

        list.remove(20);
        System.out.println("list after removing 20 = " + list.toString());

        System.out.println("index of '30' = " + list.indexOf(30));
        

        // Test task 1
        list.removeAtIndex(1);  // TBD
        System.out.println("Task 1: list after removing element at index 1 = " + list.toString());

        // Test task 2
        LinkedList list2 = new LinkedList();
        list2.add(10);
        list2.add(10);
        System.out.println("list2 = " + list2.toString());
        System.out.println("Task 2: list == list2 ?: " + list.isEqual(list2)); // not yet implemented

        // Test task 3
        LinkedList list3 = new LinkedList<Integer>();
        list3.add(10);
        list3.add(10);
        list3.add(30);
        list3.add(30);
        list3.add(60);
        list3.add(70);
        list3.add(80);
        System.out.println("list before removing repeats = " + list3.toString());
        list3.removeRepeats();
        System.out.println("Task 3: list after removing repeats = " + list3.toString());

        // Test task 4
        LinkedList list4 = new LinkedList<Integer>();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        list4.add(4);
        System.out.println("list before reverse = " + list4.toString());
        list4.reverse();
        System.out.println("Task 4: list after reverse = " + list4.toString());

        // Test task 5
        LinkedList list5 = new LinkedList<Integer>();
        list5.add(7);
        list5.add(8);
        list5.add(9);
        list5.add(10);
        LinkedList list6 = new LinkedList<Integer>();
        list6.add(1);
        list6.add(2);
        list6.add(3);
        list6.add(4);
        System.out.println("list before merging = " + list6.toString());
        list6.merge(list5);
        System.out.println("Task 5: list after merging = " + list6.toString());
    }
}
