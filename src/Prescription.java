import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prescription {
    private Doctor doctor;
    private Patient patient;
    private List<Treatment> treatments;
    private LocalDateTime createdAt;
    private boolean active;

    public Prescription(Doctor doctor, Patient patient, List<Treatment> treatments) {
        this.doctor = doctor;
        this.patient = patient;
        this.treatments = new ArrayList<>(treatments); // copy
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Treatment> getTreatments() {
        return Collections.unmodifiableList(treatments); // protect list
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Helper: check if this prescription contains a medicine by name
    public boolean hasMedicine(String medicineName) {
        if (medicineName == null) return false;

        for (Treatment t : treatments) {
            if (t instanceof Medicine && t.getName() != null
                    && t.getName().equalsIgnoreCase(medicineName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String doctorName = (doctor != null) ? doctor.getName() : "Unknown";
        String patientName = (patient != null) ? patient.getName() : "Unknown";
        String status = active ? "Active" : "Inactive";
        return "Prescription by " + doctorName + " for " + patientName 
                + " (" + status + ", " + treatments.size() + " treatments, created " + createdAt + ")";
    }
}