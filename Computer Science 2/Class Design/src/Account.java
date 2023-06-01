/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 02 - Account
 */

/* TODO: A bank account is defined by a number (integer), the name of the owner, and a balance. Users should have the ability to create an account by specifying its number and owner. Balance is always initialized to zero. The class should provide methods to allow deposit (amount informed as parameter), withdraw (amount informed as parameter; balance cannot become negative). You should also implement the “toString” method.*/
public class Account {

        private int number;
        private String owner;
        private double balance;

        public Account(int number, String owner) {
            this.number = number;
            this.owner = owner;
            balance = 0;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (balance - amount >= 0) {
                balance -= amount;
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return number + ", " + owner + ", balance: US$" + balance;
        }

}
