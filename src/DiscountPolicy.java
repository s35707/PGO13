public interface DiscountPolicy {
    default double applyDiscount(Student student, double price){
        double result = price;
        if(student.loyaltyPoints >= 100){
            result *= 0.9;
        }
        return result;
    }
}
