package firsthomeworkadvance;

public class CreditDebit {
   private  String name;
  private  int pinCode;
  private  double balance;

    public CreditDebit(String name, int pinCode, double balance) {
        this.name = name;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    }

