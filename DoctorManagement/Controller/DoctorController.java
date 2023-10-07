package Controller;

import java.util.Scanner;

import Common.Input;
import Repo.DoctorRepo;
import View.Menu;

public class DoctorController extends Menu<String> {
    DoctorRepo doctorRepo = new DoctorRepo();
     Scanner sc = new Scanner(System.in);
    
    Input input = new Input();
    static String[] mc = { "Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit" };

    public DoctorController() {
        super("Doctor Management", mc);

    }

    @Override
    public void execute(int n) {
           switch (n) {
            case 1: {
                doctorRepo.addDoctor();
                break;
            }
            case 2: {
                doctorRepo.updateDoctor();
                break;
            }
            case 3: {
                doctorRepo.deleteDoctor();
                break;
            }
            case 4: {
                doctorRepo.searchDoctor();;
                break;
            }
            case 5: {
                System.exit(0);
            }

        }
    }
    
}
