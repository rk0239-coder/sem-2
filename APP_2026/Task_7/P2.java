class Doctor {

    private final int doctorId;
    private final String name;
    private final String specialization;
    private final double consultationFee;

    public Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void displayDoctorInfo() {
        System.out.println("Doctor ID        : " + doctorId);
        System.out.println("Name             : " + name);
        System.out.println("Specialization   : " + specialization);
        System.out.println("Consultation Fee : Rs. " + consultationFee);
    }
}

class Patient {

    private final int patientId;
    private final String name;
    private final String disease;
    private final int age;

    public Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getDisease() {
        return disease;
    }

    public int getAge() {
        return age;
    }

    public void displayPatientInfo() {
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Name         : " + name);
        System.out.println("Disease      : " + disease);
        System.out.println("Age          : " + age);
    }
}

public class P2 {
    static int assignDoctor(Patient patient, Doctor[] doctors) {
        String disease = patient.getDisease().toLowerCase();

        for (int i = 0; i < doctors.length; i++) {
            String specialization = doctors[i].getSpecialization().toLowerCase();

            if (specialization.contains("cardio") &&
                    (disease.contains("heart") || disease.contains("chest"))) {
                return i;
            }
            if (specialization.contains("ortho") &&
                    (disease.contains("fracture") || disease.contains("bone") || disease.contains("joint"))) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Doctor[] doctors = {
                new Doctor(101, "Dr. Ashok Mehta", "Cardiologist", 800.0),
                new Doctor(102, "Dr. Priya Nair", "Orthopedic", 600.0)
        };

        Patient[] patients = {
                new Patient(1, "Ravi Kumar", "Chest Pain", 45),
                new Patient(2, "Sneha Verma", "Fracture in Leg", 30),
                new Patient(3, "Manoj Singh", "Heart Palpitations", 52)
        };

        int[] assignedDoctorIndex = new int[patients.length];
        int[] patientCountPerDoctor = new int[doctors.length];

        for (int i = 0; i < patients.length; i++) {
            int doctorIndex = assignDoctor(patients[i], doctors);
            assignedDoctorIndex[i] = doctorIndex;
            patientCountPerDoctor[doctorIndex]++;
        }

        System.out.println("=== Patient - Doctor Assignment ===\n");
        for (int i = 0; i < patients.length; i++) {
            Doctor assignedDoctor = doctors[assignedDoctorIndex[i]];

            System.out.println("-- Patient Details --");
            patients[i].displayPatientInfo();

            System.out.println("-- Treating Doctor --");
            assignedDoctor.displayDoctorInfo();

            System.out.println();
        }

        System.out.println("=== Total Consultation Fee Collected ===");
        for (int i = 0; i < doctors.length; i++) {
            double totalFee = doctors[i].getConsultationFee() * patientCountPerDoctor[i];
            System.out.println(doctors[i].getName() + " (" + doctors[i].getSpecialization() + ") -> " +
                    patientCountPerDoctor[i] + " patient(s), Total Fee: Rs. " + totalFee);
        }
    }
}
