public class Nurse extends Staff {

    public Nurse(String name, int age) {
        super(name, age, "Nurse");
    }

    @Override
    public void performDuties() {
        // Basic nurse duties
        System.out.println(getName() + " supports doctor and cares for patients.");
    }

    public void checkVitals(Patient patient) {
        // Fake vitals just for demo
        if (patient == null) {
            System.out.println(getName() + " cannot check vitals (no patient).");
            return;
        }
        System.out.println(getName() + " checks vitals of " + patient.getName() + " (OK).");
    }
}