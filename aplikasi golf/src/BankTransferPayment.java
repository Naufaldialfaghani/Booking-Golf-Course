public class BankTransferPayment extends PaymentMethod {
    private String bankAccount;

    public BankTransferPayment(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bank Transfer from account: " + bankAccount);
    }
}
