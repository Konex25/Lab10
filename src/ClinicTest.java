public class ClinicTest {
    public static void main(String[] args) {

        // Create staff
        Doctor doc = new Doctor("Dr. Kowalski", 45);
        Nurse nurse = new Nurse("Anna", 30);
        Receptionist rec = new Receptionist("Tomasz", 28);

        // Create patients (different conditions)
        Patient p1 = new Patient("Konrad", 22, "flu");
        Patient p2 = new Patient("Ola", 31, "injury");
        Patient p3 = new Patient("Marek", 40, "checkup");

        // Introductions (all persons)
        System.out.println("=== Introductions ===");
        doc.introduce();
        nurse.introduce();
        rec.introduce();
        p1.introduce();
        p2.introduce();
        p3.introduce();

        // Staff duties
        System.out.println("\n=== Staff duties ===");
        doc.performDuties();
        nurse.performDuties();
        rec.performDuties();

        // Patient treatment
        System.out.println("\n=== Treatment ===");
        p1.receiveTreatment();
        p2.receiveTreatment();
        p3.receiveTreatment();

        // Unique subclass methods
        System.out.println("\n=== Unique methods ===");
        doc.prescribeMedicine(p1, "Paracetamol");
        nurse.checkVitals(p2);
    }
}