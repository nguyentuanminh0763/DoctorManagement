package Repo;

import java.util.HashMap;

import DataAccess.DoctorDao;
import Model.Doctor;

public class DoctorRepo implements IDoctorRepo {
    private HashMap<String, Doctor> doctorHashMap;

    public DoctorRepo() {
        this.doctorHashMap = new HashMap<>();
    }

    @Override
    public void addDoctor() {
        try {
            if (DoctorDao.Instance().addDoctor(doctorHashMap)) {
                System.out.println("Add successful!!");
            } else {
                System.out.println("Cant Add");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteDoctor() {
        try {
            if (DoctorDao.Instance().deleteDoctor(doctorHashMap)) {
                System.out.println("Delete Successfull!!");
            } else {
                System.out.println("Cant Delete..");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateDoctor() {
        try {
            if (DoctorDao.Instance().updateDoctor(doctorHashMap)) {
                System.out.println("Update Successfull!");
            } else {
                System.out.println("Cant Update..");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void searchDoctor() {
        try {
            displayAllDoctor(DoctorDao.Instance().searchDoctor(doctorHashMap));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public HashMap<String, Doctor> getAllDoctorHashMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllDoctorHashMap'");
    }

    @Override
    public Doctor getDoctorByCode(String codeDoctor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDoctorByCode'");
    }

    @Override
    public void displayAllDoctor(HashMap<String, Doctor> doctorHashMap) {
        DoctorDao.Instance().displayAllDoctor(doctorHashMap);
    }

}
