import java.time.LocalDateTime;

public class Appointment {
    private LocalDateTime dateTime;
    private Patient patient;
    private Doctor doctor;

    public Appointment(LocalDateTime dateTime, Patient patient, Doctor doctor) {
        this.dateTime = dateTime;
        this.patient = patient;
        this.doctor = doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        String patientName = (patient != null) ? patient.getName() : "Unknown";
        String doctorName = (doctor != null) ? doctor.getName() : "Unknown";
        return "Appointment with " + doctorName + " for " + patientName + " at " + dateTime;
    }
}