
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;

    public Patient(String name, int age, String gender, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Phone Number: " + phoneNumber;
    }
}

class HospitalSystem {
    private ArrayList<Patient> patients;
    private Scanner scanner;

    public HospitalSystem() {
        patients = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createPatient() {
        System.out.println("Enter patient name:");
        String name = scanner.nextLine();

        System.out.println("Enter patient age:");
        int age = scanner.nextInt();

        scanner.nextLine(); // Consume newline
        System.out.println("Enter patient gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter patient phone number:");
        String phoneNumber = scanner.nextLine();

        Patient newPatient = new Patient(name, age, gender, phoneNumber);
        patients.add(newPatient);
        System.out.println("Patient registered successfully!");

        System.out.println("Add another Patient registered successfully? (y/n):");
        String choice = scanner.nextLine().toLowerCase();
        //choice.equals(y/n);

//        System.out.println("Add another Patient registered successfully? (y/n):");
//        String = scanner.nextLine().toLowerCase("");
//         (choice.equals(y / n)) {
        ;
    }


    public void readPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }

        System.out.println("List of registered patients in the Hospital:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void updatePatient() {
        System.out.println("Enter the name of the patient to update:");
        String name = scanner.nextLine();
        boolean found = false;
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println("Enter new age:");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new gender:");
                String gender = scanner.nextLine();
                System.out.println("Enter new phone number:");
                String phoneNumber = scanner.nextLine();

                patient.setAge(age);
                patient.setGender(gender);
                patient.setPhoneNumber(phoneNumber);

                System.out.println("Patient information updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Patient not found!");
        }
    }

    public void deletePatient() {
        System.out.println("Enter the name of the patient to delete:");
        String name = scanner.nextLine();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getName().equalsIgnoreCase(name)) {
                patients.remove(i);
                System.out.println("Patient removed successfully!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    public static void main(String[] args) {
        HospitalSystem hospitalSystem = new HospitalSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n      ------------------- YOU`RE WELCOME!----------------------");
            System.out.println("\n------------------- Hospital Patient Registration System----------------------");
            System.out.println("                        1. Register Patient");
            System.out.println("                        2. View Patients");
            System.out.println("                        3. Update Patient");
            System.out.println("                        4. Delete Patient");
            System.out.println("                        5. Exit");
            System.out.println("                        Enter your choice:");
            System.out.println("\n      ---------------------------------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hospitalSystem.createPatient();
                    break;
                case 2:
                    hospitalSystem.readPatients();
                    break;
                case 3:
                    hospitalSystem.updatePatient();
                    break;
                case 4:
                    hospitalSystem.deletePatient();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
