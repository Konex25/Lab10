import java.time.LocalDateTime;

public abstract class Staff extends Person {
    private String role;

    public Staff(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void introduce() {
        System.out.println("Name: " + getName() + " | Age: " + getAge() + " | Role: " + role);
    }

    public abstract void performDuties();

    // Staff can create appointments as part of their duties
    public Appointment scheduleAppointment(Patient patient, Doctor doctor, LocalDateTime dateTime) {
        if (patient == null || doctor == null || dateTime == null) {
            return null;
        }

        Appointment appointment = new Appointment(dateTime, patient, doctor);
        
        if (!doctor.addAppointment(appointment)) {
            return null; // time slot taken
        }

        patient.addAppointment(appointment);
        return appointment;
    }
}