public class Student implements Displayable{
    String id;
    String fullName;
    int groupId;
    int loyaltyPoints;

    public Student(String id,String fullName,int groupId,int loyaltyPoints){
        this.id = id;
        this.fullName = fullName;
        this.groupId = groupId;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getDisplayText(){
        return this.fullName + " id: " + this.id + " loyalty points: " + this.loyaltyPoints;
    }

}
