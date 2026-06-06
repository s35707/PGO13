public class Reservation implements Displayable, DiscountPolicy{
    String id;
    Student student;
    Equipment equipment;
    int days;
    ReservationStatus status;

    public Reservation(String id, Student student, Equipment equipment, int days, ReservationStatus status){
        this.id = id;
        this.student = student;
        this.equipment = equipment;
        this.days = days;
        this.status = status;

    }

    public double calculateTotalCost(){
        return (applyDiscount(this.student, this.equipment.calculateDailyPrice() * this.days));
    }


    @Override
    public String getDisplayText() {
        return "ID: "+this.id+" Student: "+this.student.fullName+" Equipment: "+this.equipment.name+" Status: "+this.status;
    }
}
