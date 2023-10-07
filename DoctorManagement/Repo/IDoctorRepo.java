package Repo;

import java.util.HashMap;

import Model.Doctor;

public interface IDoctorRepo {
    
   void addDoctor();
   void deleteDoctor();
   void updateDoctor();
   void searchDoctor();
   void displayAllDoctor(HashMap<String, Doctor> doctorHashMap);

    HashMap<String, Doctor> getAllDoctorHashMap();
    Doctor getDoctorByCode(String codeDoctor);

}