import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctor extends Staff {

    // Doctor has many appointments
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(String name, int age) {
        super(name, age, "Doctor");
    }

    @Override
    public void performDuties() {
        // Basic doctor duties
        System.out.println(getName() + " examines patients and makes diagnoses.");
    }

    public List<Appointment> getAppointments() {
        return Collections.unmodifiableList(appointments);
    }

    // Check if appointment overlaps
    public boolean hasOverlappingAppointment(LocalDateTime dateTime) {
        if (dateTime == null) return false;

        for (Appointment a : appointments) {
            if (a.getDateTime().equals(dateTime)) {
                return true;
            }
        }
        return false;
    }

    public boolean addAppointment(Appointment appointment) {
        if (appointment == null || appointment.getDateTime() == null) {
            return false;
        }

        if (hasOverlappingAppointment(appointment.getDateTime())) {
            return false; // overlap big no no
        }

        appointments.add(appointment);
        return true;
    }

    public Prescription createPrescription(Patient patient, List<Treatment> treatments) {
        if (patient == null || treatments == null || treatments.isEmpty()) {
            return null;
        }

        Prescription prescription = new Prescription(this, patient, treatments);
        patient.addPrescription(prescription);
        return prescription;
    }

    public void prescribeMedicine(Patient patient, String medicine) {
        if (patient == null) {
            System.out.println(getName() + " cannot prescribe medicine (no patient :c ).");
            return;
        }
        System.out.println(getName() + " prescribes " + medicine + " to " + patient.getName() + ".");
    }
}