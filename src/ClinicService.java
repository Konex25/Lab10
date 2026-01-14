import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClinicService implements ClinicOperations {

    // Track all patients in the system
    private Set<Patient> allPatients = new HashSet<>();

    @Override
    public boolean addAppointment(Staff createdBy, Patient patient, Doctor doctor, Appointment appointment) {
        // Simple null checks
        if (createdBy == null || patient == null || doctor == null || appointment == null) return false;

        // Doctor must not overlap
        boolean addedToDoctor = doctor.addAppointment(appointment);
        if (!addedToDoctor) {
            System.out.println("Cannot add appointment: overlaps for doctor " + doctor.getName());
            return false;
        }

        // Store on patient too
        patient.addAppointment(appointment);

        // Track this patient
        allPatients.add(patient);

        System.out.println(createdBy.getName() + " created appointment for " + patient.getName()
                + " with " + doctor.getName() + " at " + appointment.getDateTime());
        return true;
    }

    @Override
    public void displayAppointmentsForPatient(Patient patient) {
        if (patient == null) return;

        System.out.println("Appointments for patient: " + patient.getName());
        if (patient.getAppointments().isEmpty()) {
            System.out.println("  (none)");
            return;
        }

        for (Appointment a : patient.getAppointments()) {
            System.out.println("  - " + a);
        }
    }

    @Override
    public void displayAppointmentCalendarForDoctor(Doctor doctor) {
        if (doctor == null) return;

        System.out.println("Calendar for doctor: " + doctor.getName());
        if (doctor.getAppointments().isEmpty()) {
            System.out.println("  (none)");
            return;
        }

        for (Appointment a : doctor.getAppointments()) {
            System.out.println("  - " + a);
        }
    }

    @Override
    public void addPrescription(Doctor doctor, Patient patient, Prescription prescription) {
        if (doctor == null || patient == null || prescription == null) return;

        patient.addPrescription(prescription);

        allPatients.add(patient);

        System.out.println(doctor.getName() + " created prescription for " + patient.getName());
    }

    @Override
    public void displayPrescriptionsForPatient(Patient patient) {
        if (patient == null) return;

        System.out.println("Prescriptions for patient: " + patient.getName());
        if (patient.getPrescriptions().isEmpty()) {
            System.out.println("  (none)");
            return;
        }

        for (Prescription p : patient.getPrescriptions()) {
            System.out.println("  - " + p);
        }
    }

    @Override
    public List<String> findPatientsWithActivePrescriptionForMedicine(String medicineName) {
        List<String> result = new ArrayList<>();
        if (medicineName == null) return result;

        for (Patient patient : allPatients) {
            for (Prescription pres : patient.getPrescriptions()) {
                if (pres.isActive() && pres.hasMedicine(medicineName)) {
                    String doctorName = (pres.getDoctor() == null) ? "Unknown doctor" : pres.getDoctor().getName();
                    result.add(patient.getName() + " -> " + medicineName + " (Doctor: " + doctorName + ")");
                }
            }
        }

        return result;
    }
}