public class AccountDriver {

    public static void main(String[] args) {

        Account acc = new Account(123, "Thyago");
        acc.deposit(100);
        System.out.println(acc);
    }
}
