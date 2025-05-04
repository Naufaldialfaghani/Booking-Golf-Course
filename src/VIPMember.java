public class VIPMember extends Member {
    private double discount;

    public VIPMember(String name, String email, double discount) {
        super(name, email);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
