public class CameraKit extends Equipment{
    int lensCount;
    boolean hasTripod;

    public CameraKit(String id, String name, double baseDailyPrice, boolean available, int lensCount, boolean hasTripod){
        super(id,name,baseDailyPrice,available);
        this.lensCount = lensCount;
        this.hasTripod = hasTripod;
    }

    @Override
    public double calculateDailyPrice() {
        double result = this.baseDailyPrice + (10 * this.lensCount);
        if(hasTripod){
            result += 15;
        }
        return result;
    }

    @Override
    public String getDisplayText() {
        return super.getDisplayText()+" lens count: "+this.lensCount;
    }
}
