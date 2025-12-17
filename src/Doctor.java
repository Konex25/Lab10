public class Doctor extends Staff {

    public Doctor(String name, int age) {
        super(name, age, "Doctor");
    }

    @Override
    public void performDuties() {
        // Basic doctor duties
        System.out.println(getName() + " examines patients and makes diagnoses.");
    }

    // Doctor unique method
    public void prescribeMedicine(Patient patient, String medicine) {
        if (patient == null) {
            System.out.println(getName() + " cannot prescribe medicine (no patient).");
            return;
        }
        System.out.println(getName() + " prescribes " + medicine + " to " + patient.getName() + ".");
    }
}