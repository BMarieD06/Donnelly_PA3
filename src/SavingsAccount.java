
public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount()
    {
        savingsBalance = 0;
        annualInterestRate = 0;
    }

    public SavingsAccount(double balance)
    {
        savingsBalance = balance;
        annualInterestRate = 0;
    }

    public void calculateMonthlyInterest()
    {
        System.out.println("Current savings balance: " + savingsBalance);
        double monthlyInterest;
        monthlyInterest = (savingsBalance * annualInterestRate)/12;
        System.out.println("Monthly interest rate is: " + monthlyInterest);
        savingsBalance += monthlyInterest;
        System.out.println("New savings balance: " + savingsBalance + "\n");

    }

    public double getBalance()
    {
        return savingsBalance;
    }

    public static void modifyInterestRate(double newIntRate)
    {
        annualInterestRate = newIntRate;
    }


}
