import java.time.LocalDateTime;
import java.util.List;

public class ClinicTest {
    public static void main(String[] args) {

        // Create staff
        Doctor doc = new Doctor("Dr. Kowalski", 45);
        Nurse nurse = new Nurse("Anna", 30);
        Receptionist rec = new Receptionist("Tomasz", 28);

        // Create patients
        Patient p1 = new Patient("Konrad", 22, "flu");
        Patient p2 = new Patient("Ola", 31, "injury");
        Patient p3 = new Patient("Marek", 40, "checkup");

        // Introductions
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

        // Unique methods (old)
        System.out.println("\n=== Unique methods (old) ===");
        doc.prescribeMedicine(p1, "Paracetamol");
        nurse.checkVitals(p2);

        // ===== EXTENDED SYSTEM DEMO =====
        System.out.println("\n=== Extended system demo ===");

        // Clinic operations service
        ClinicOperations clinic = new ClinicService();

        // 1) Add appointments (staff can create appointments)
        Appointment a1 = new Appointment(LocalDateTime.of(2025, 12, 18, 10, 0), p1, doc);
        Appointment a2 = new Appointment(LocalDateTime.of(2025, 12, 18, 11, 0), p2, doc);

        clinic.addAppointment(rec, p1, doc, a1);
        clinic.addAppointment(nurse, p2, doc, a2);

        // Try to add overlapping appointment (should fail)
        Appointment a3 = new Appointment(LocalDateTime.of(2025, 12, 18, 10, 0), p3, doc);
        clinic.addAppointment(rec, p3, doc, a3);

        // 2) Display all appointments for a given patient
        System.out.println("\n--- Appointments for patient: " + p1.getName() + " ---");
        clinic.displayAppointmentsForPatient(p1);

        // 3) Display appointment calendar for a given doctor
        System.out.println("\n--- Calendar for doctor: " + doc.getName() + " ---");
        clinic.displayAppointmentCalendarForDoctor(doc);

        // 4) Add and display prescriptions for a given patient
        // Doctor creates prescription (requirement #2)
        Treatment t1 = new Medicine("Paracetamol");
        Treatment t2 = new Treatment("Rest and fluids");

        Prescription pr1 = doc.createPrescription(p1, List.of(t1, t2));
        clinic.addPrescription(doc, p1, pr1);

        System.out.println("\n--- Prescriptions for patient: " + p1.getName() + " ---");
        clinic.displayPrescriptionsForPatient(p1);

        // 5) Display all patients with active prescription for given medicine
        System.out.println("\n--- Patients with active Paracetamol ---");
        List<String> results = clinic.findPatientsWithActivePrescriptionForMedicine("Paracetamol");
        if (results.isEmpty()) {
            System.out.println("  (none - need to pass all patients to service)");
        } else {
            for (String r : results) {
                System.out.println("  " + r);
            }
        }
    }
}