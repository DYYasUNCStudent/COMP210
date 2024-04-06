package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO (Task 1): dequeue
    public Patient dequeue() {
        if (this.size() == 0) {
            return null;
        }

        int high_PriorityIndex = 0;
        List<Patient> Checklist = this.patients;
        Patient high_PrioirityPatient = Checklist.get(0);

        for (int i = 1; i < Checklist.size(); i++) {
            Patient currentPatient = Checklist.get(i);
            if ((currentPatient.getPriority().compareTo(high_PrioirityPatient.getPriority()) > 0)) {
                high_PriorityIndex = i;
                high_PrioirityPatient = currentPatient;
            }
        }
        this.patients.remove(high_PriorityIndex);
        return high_PrioirityPatient;
    	}

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
