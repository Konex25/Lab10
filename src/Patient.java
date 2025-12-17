import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient extends Person implements Treatable {

    private String condition;

    // Patient can have many prescriptions and appointments
    private List<Prescription> prescriptions = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String name, int age, String condition) {
        super(name, age);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public void receiveTreatment() {
        String cond = (condition == null) ? "" : condition;

        if (cond.equalsIgnoreCase("flu")) {
            System.out.println(getName() + " gets rest + fluids treatment.");
        } else if (cond.equalsIgnoreCase("injury")) {
            System.out.println(getName() + " gets wound care treatment.");
        } else {
            System.out.println(getName() + " gets general consultation.");
        }
    }

    public void addPrescription(Prescription prescription) {
        if (prescription != null) {
            prescriptions.add(prescription);
        }
    }

    public List<Prescription> getPrescriptions() {
        return Collections.unmodifiableList(prescriptions);
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
        }
    }

    public List<Appointment> getAppointments() {
        return Collections.unmodifiableList(appointments);
    }
}