package DataAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Common.Input;
import Model.Doctor;

public class DoctorDao {
    Scanner sc = new Scanner(System.in);
    Input input = new Input();

    private static DoctorDao instance = null;

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    public class DatabaseNotFoundException extends Exception {
        public DatabaseNotFoundException(String message) {
            super(message);
        }
    }

    public class DuplicateDoctorCodeException extends Exception {
        public DuplicateDoctorCodeException(String message) {
            super(message);
        }
    }

    public class DataNotFoundException extends Exception {
        public DataNotFoundException(String message) {
            super(message);
        }
    }

    public boolean isCodeExist(HashMap<String, Doctor> doctorHashMap, String codeDoctor) {
        return doctorHashMap.containsKey(codeDoctor);
    }

    public boolean isNullDoctor(String code, String name, String specialization) {
        if (code == "" || name == "" || specialization == "") {
            return true;
        }
        return false;
    }

    public boolean isNullDoctorAND(String code, String name, String specialization) {
        if (code == "" && name == "" && specialization == "") {
            return true;
        }
        return false;
    }

    public boolean addDoctor(HashMap<String, Doctor> doctorHashMap) throws Exception {

        System.out.println("Enter Code: ");
        String code = sc.nextLine().trim();

        System.out.println("Enter Name: ");
        String name = sc.nextLine().trim();

        System.out.println("Enter Specialization: ");
        String specialization = sc.nextLine().trim();

        int availability = input.getInt("Enter Availabity[1 or 2 or 3]: ", 1, 3);

        if (isCodeExist(doctorHashMap, code)) {
            throw new DuplicateDoctorCodeException("Doctor code [Code] is duplicate");
        }
        if (isNullDoctor(code, name, specialization)) {
            throw new DataNotFoundException("Data does not exist");
        }

        if (isCodeExist(doctorHashMap, code) || isNullDoctor(code, name, specialization)) {
            return false;
        }
        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctorHashMap.put(code, doctor);
        return true;

        

    }

    public boolean deleteDoctor(HashMap<String, Doctor> doctorHashMap) throws Exception {

        System.out.println("Enter code: ");
        String code = sc.nextLine().trim();

        if (!isCodeExist(doctorHashMap, code)) {
            throw new DuplicateDoctorCodeException("Doctor code doesn't exist");

        }

        if (isNullDoctor(code, "l", "l")) {
            throw new DataNotFoundException("Data does not exist");
        }

        if (doctorHashMap.isEmpty()) {
            throw new DatabaseNotFoundException("Database does not exist");
        }

        if (!isCodeExist(doctorHashMap, code) || isNullDoctor(code, "l", "l")) {
            return false;
        }

        doctorHashMap.remove(code);
        return true;
    }

    public boolean updateDoctor(HashMap<String, Doctor> doctorHashMap) throws Exception {
        System.out.println("Enter code: ");
        String code = sc.nextLine().trim();

        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        if (name == "") {
            name = doctorHashMap.get(code).getNameDoctor();
        }

        System.out.println("Enter Specialization: ");
        String sp = sc.nextLine();
        if (sp == "") {
            sp = doctorHashMap.get(code).getSpecializationDoctor();
        }

        System.out.println("Enter Availability: ");
        String avai = sc.nextLine();
        int oldAvai =1;
        if (avai == "") {
            oldAvai = doctorHashMap.get(code).getAvailabilityDoctor();
        }else{
            oldAvai = Integer.parseInt(avai);
        }

        if (!isCodeExist(doctorHashMap, code)) {
            throw new DuplicateDoctorCodeException("Doctor code doesn't exist");
        }

        if (isNullDoctorAND(code, name, sp)) {
            throw new DataNotFoundException("Data does not exist");
        }

        if (!isCodeExist(doctorHashMap, code)) {
            return false;
        }

        Doctor doctorUpdate = new Doctor(code, name, sp, oldAvai);
        doctorHashMap.put(code, doctorUpdate);
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(HashMap<String, Doctor> doctorHashMap) throws Exception {
        HashMap<String, Doctor> doctorSearchHashMap = new HashMap<>();

        System.out.println("Enter String: ");
        String codeDoctorSearch = sc.nextLine().trim();

        if (doctorHashMap.isEmpty()) {
            throw new DatabaseNotFoundException("Database does not exist");
        }

        if (doctorHashMap.isEmpty()) {
            return null;
        }

        for (Map.Entry<String, Doctor> entry : doctorHashMap.entrySet()) {
            if (entry.getValue().getNameDoctor().toLowerCase().contains(codeDoctorSearch.toLowerCase())) {
                doctorSearchHashMap.put(entry.getKey(), entry.getValue());
            }
        }

        return doctorSearchHashMap;
    }

    public void displayAllDoctor(HashMap<String, Doctor> doctorHashMap) {
      
        System.out.println("------------------------Result------------------------");
        System.out.printf("%-10s%-10s%-16s%-15s\n", "Code", "Name", "Specialization", "Availability");
        for (Map.Entry<String, Doctor> entry : doctorHashMap.entrySet()) {
            System.out.printf("%-10s%-10s%-16s%-15d\n", entry.getValue().getCodeDoctor(),
                    entry.getValue().getNameDoctor(), entry.getValue().getSpecializationDoctor(),
                    entry.getValue().getAvailabilityDoctor());
        }
        System.out.println("------------------------------------------------------\n");
    }
}
