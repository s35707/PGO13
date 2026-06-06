import java.util.ArrayList;
import java.util.Objects;

public class ReservationService {
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public static void createReservation( Student student, Equipment equipment, int days){
        if(days<1||days>14)
            System.out.println("The number of days must be between 1 and 14");
        else if(!equipment.available)
            System.out.println("Equipment unavaliable");
        else {
            String id = "R" + (reservations.size() + 1);
            reservations.add(new Reservation(id, student, equipment, days, ReservationStatus.ACTIVE));
            equipment.available = false;
            System.out.println("Reservation "+id+" succesfully created!");
            System.out.println("Equipment: "+equipment.name);
            System.out.println("Cost: "+findById(id).calculateTotalCost()+" PLN");
            System.out.println("Status: ACTIVE"); //this is always active so I can simplify it

        }
    }

    public static Reservation findById(String id){
        return reservations.stream().filter(reservation -> Objects.equals(reservation.id, id)).toList().getFirst();
    }

    public static void printActiveReservations(){
        System.out.println("All ACTIVE reservations: ");
        reservations.stream().filter(reservation -> reservation.status == ReservationStatus.ACTIVE).map(Reservation::getDisplayText).forEach(System.out::println);
    }

    public static void printReport(){
        printActiveReservations();
        System.out.println("All COMPLETED reservations: ");
        reservations.stream().filter(reservation -> reservation.status == ReservationStatus.RETURNED).map(Reservation::getDisplayText).forEach(System.out::println);
        int x = 0;
        double sum = 0;
        while(x < reservations.stream().filter(reservation -> reservation.status == ReservationStatus.RETURNED).map(Reservation::calculateTotalCost).toList().size()){
            sum += reservations.stream().filter(reservation -> reservation.status == ReservationStatus.RETURNED).map(Reservation::calculateTotalCost).toList().get(x);
            x++;
        }
        System.out.println("Revenue from completed reservations: "+sum);

    }

    public static void returnEquipment(String id){
        Reservation reservation = findById(id);
        if(reservation == null)
            System.out.println("Reservation doesn't exist");
        else if(reservation.status != ReservationStatus.ACTIVE)
            System.out.println("Reservation isn't active");
        else{
            reservation.status = ReservationStatus.RETURNED;
            reservation.equipment.available = true;
            reservation.student.loyaltyPoints += (int) (reservation.calculateTotalCost()/10);
            System.out.println("Equipment returned. The student received "+(int) (reservation.calculateTotalCost()/10)+" loyalty points");
        }
    };

}
