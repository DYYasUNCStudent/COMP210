package assn05;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        testP1();
        testP2();
        testP3();
        testP4();
    }

    // test Part 1
    public static void testP1(){
        System.out.println("___Test 1___");
        SimpleEmergencyRoom One_room = new SimpleEmergencyRoom();
        One_room.addPatient("Cold",5);
        One_room.addPatient("Coughing", 1);
        One_room.addPatient("Minor Injury", 3);
        One_room.addPatient("Headshot", 9);
        One_room.addPatient("Avoiding school", 2);
        System.out.println("The patient just finished surgery has the issue: " + One_room.dequeue().getValue());
    }

    // test Part 2
    public static void testP2(){
        System.out.println("___Test 2a___");
        MaxBinHeapER Test = new MaxBinHeapER<>();
        Test.enqueue("Cold", 5);
        Test.enqueue("Coughing", 1);
        Test.enqueue("Minor Injury", 3);
        Test.enqueue("Headshot", 9);
        Test.enqueue("Avoiding school", 2);
        for (int i = 0; i < Test.size(); i++){
            System.out.println("Value: " + Test.getAsArray()[i].getValue()
                    + ", Priority: " + Test.getAsArray()[i].getPriority());
        }
        Test.dequeue();
        for (int i = 0; i < Test.size(); i++){
            System.out.println("Value: " + Test.getAsArray()[i].getValue()
                    + ", Priority: " + Test.getAsArray()[i].getPriority());
        }
        System.out.println("The patient with the highest priority has the Value: " + Test.getMax());

        System.out.println("___Test 2b___");
        MaxBinHeapER Test2 = new MaxBinHeapER<>();
        Test2.enqueue("Cold", 5);
        Test2.enqueue("Coughing", 1);
        Test2.enqueue("Minor Injury", 3);
        Test2.enqueue("Headshot", 9);
        Test2.enqueue("Avoiding school", 2);
        for(int i = 0; i < Test2.size(); i++) {
            System.out.println("Value: " + Test2.getAsArray()[i].getValue()
                    + ", Priority: " + Test2.getAsArray()[i].getPriority());
        }
        Test2.updatePriority("Avoiding school", 10);
        Test2.updatePriority("Headshot", 4);
        Test2.updatePriority("Avoiding COMP-210", 10);
        for(int i = 0; i < Test2.size(); i++) {
            System.out.println("Value: " + Test2.getAsArray()[i].getValue()
                    + ", Priority: " + Test2.getAsArray()[i].getPriority());
        }
    }
    /*
    Part 3
     */
    public static void testP3(){
        System.out.println("___Test 3___");
        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }
    }
    /*
    Part 4
     */
    public static void testP4() {
        double[] results = compareRuntimes();
        System.out.println("Results:");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }

    public static double[] compareRuntimes() {
        // Array which you will populate as part of Part 4
        System.out.println("Comparing....");
        double[] results = new double[4];

        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (Task 4.1) Here
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            simplePQ.dequeue();
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        results[0] = duration;
        results[1] = (double) duration / 100000.0;

        // Code for (Task 4.2) Here
        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            binHeap.dequeue();
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        results[2] = duration;
        results[3] = (double) duration / 100000.0;

        return results;
    }

}
