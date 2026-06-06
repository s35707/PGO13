abstract class Equipment implements Displayable{
    String id;
    String name;
    double baseDailyPrice;
    boolean available;

    public Equipment(String id, String name, double baseDailyPrice, boolean available){
        this.id = id;
        this.name = name;
        this.baseDailyPrice = baseDailyPrice;
        this.available = available;
    }

    public double calculateDailyPrice(){
        return this.baseDailyPrice;
    }

    @Override
    public String getDisplayText() {
        return "Name: "+this.name + " ID: " + this.id;
    }
}
