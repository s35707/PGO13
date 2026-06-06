import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new LaptopSet("E1", "laptop1", 50,true, 32, true));
        equipmentList.add(new LaptopSet("E2", "laptop2", 50,true, 8, false));
        equipmentList.add(new LaptopSet("E3", "laptop3", 50,true, 16, false));
        equipmentList.add(new CameraKit("E4", "cameraKit1", 10,true, 3, true));
        equipmentList.add(new CameraKit("E5", "cameraKit2", 10,true, 1, false));
        equipmentList.add(new CameraKit("E6", "cameraKit3", 10,true, 1, true));

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S1", "Meg Thomas", 13, 100));
        studentList.add(new Student("S2", "Dwight Fairfield", 12, 30));
        studentList.add(new Student("S3", "Jake Park", 9, 0));
        studentList.add(new Student("S4", "Feng Min", 4, 50));
        studentList.add(new Student("S5", "Yui Kimura", 1, 15));

        int x = 1;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("1. Display equipment\n" +
                "2. Create reservation\n" +
                "3. Return equipment\n" +
                "4. Show active reservations\n" +
                "5. Show report\n" +
                "0. Exit");
        while(x != 0){
            System.out.println("Choice: ");
            x = scanner.nextInt();
            if(x == 1){
                int y = 0;
                while(y<equipmentList.size()){
                    System.out.println(equipmentList.get(y).getDisplayText());
                    y++;
                }
            }

            else if(x == 2){
                System.out.println("Enter student id: ");
                String studentId = scanner1.nextLine();
                System.out.println(studentId);
                Student student = studentList.stream().filter(student1 -> Objects.equals(student1.id, studentId)).toList().getFirst();

                System.out.println("Enter equipment id: ");
                String equipmentId = scanner1.nextLine();
                Equipment equipment = equipmentList.stream().filter(equipment1 -> Objects.equals(equipment1.id, equipmentId)).toList().getFirst();


                System.out.println("Enter number of days: ");
                int days = scanner.nextInt();
                ReservationService.createReservation(student,equipment,days);
            }
            else if (x == 3) {
                System.out.println("Enter reservation id: ");
                String id = scanner1.nextLine();
                ReservationService.returnEquipment(id);

            } else if (x == 4) {
                ReservationService.printActiveReservations();
            } else if (x == 5) {
                ReservationService.printReport();

            }
        }

    }
}