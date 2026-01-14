import java.util.List;

public interface ClinicOperations {

    // 1) Add an appointment (created by staff)
    boolean addAppointment(Staff createdBy, Patient patient, Doctor doctor, Appointment appointment);

    // 2) Display all appointments for a patient
    void displayAppointmentsForPatient(Patient patient);

    // 3) Display calendar for a doctor
    void displayAppointmentCalendarForDoctor(Doctor doctor);

    // 4) Add and display prescriptions for a patient
    void addPrescription(Doctor doctor, Patient patient, Prescription prescription);
    void displayPrescriptionsForPatient(Patient patient);

    // 5) Find patients with active prescription for medicine + doctor name
    List<String> findPatientsWithActivePrescriptionForMedicine(String medicineName);
}