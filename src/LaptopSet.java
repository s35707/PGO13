public class LaptopSet extends Equipment{
    int ramGb;
    boolean hasDockingStation;

    public LaptopSet(String id, String name, double baseDailyPrice, boolean available, int ramGb, boolean hasDockingStation){
        super(id,name,baseDailyPrice,available);
        this.ramGb = ramGb;
        this.hasDockingStation = hasDockingStation;
    }


    @Override
    public double calculateDailyPrice(){
        double result = this.baseDailyPrice;
        if(this.hasDockingStation){
            result += 15;
        }
        if(this.ramGb>= 32){
            result += 25;
        }
        return result;
    }




    @Override
    public String getDisplayText() {
        return super.getDisplayText()+" RamGb: "+this.ramGb;
    }
}
