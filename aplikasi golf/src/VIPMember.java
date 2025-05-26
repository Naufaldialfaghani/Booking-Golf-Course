    public class VIPMember extends Member {
        private double discount;

        public VIPMember(String name, String email, double discount) {
            super(name, email);
            this.discount = discount;
        }

        @Override
    public double calculateTotal(double originalPrice) {
        return originalPrice * (1 - discount);
    }

        public double getDiscount() {
            return discount;
        }
    }
