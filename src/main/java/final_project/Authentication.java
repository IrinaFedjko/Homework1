package final_project;

    import java.util.Scanner;


    public class Authentication {

        private String password = "barbora";
        static Scanner scanner = new Scanner(System.in);

        public int checkPassword() {


            int numberOfTries = 3;
            while (numberOfTries > 0) {
                System.out.println("Enter the password: ");
                String userEnteredPassword = scanner.next();
                if (userEnteredPassword.equals(password)) {
                    System.out.println("Welcome to Barbora database! Here client's orders for today!");
                    break;
                } else if (!userEnteredPassword.equals(password) && numberOfTries == 3) {
                    System.out.println("Wrong input!You have 2 attempts left.");
                } else if (!userEnteredPassword.equals(password) && numberOfTries == 2) {
                    System.out.println("Wrong input!You have 1 attempt left");
                } else if (!userEnteredPassword.equals(password) && numberOfTries == 1) {
                    System.out.println("Wrong input! Bye!");
                    System.exit(numberOfTries);
                }
                numberOfTries = numberOfTries - 1;
            }
            return numberOfTries;
        }
    }

