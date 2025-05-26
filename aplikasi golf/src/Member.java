public class Member {
    private String name;
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public double calculateTotal(double originalPrice) {
        return originalPrice;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
