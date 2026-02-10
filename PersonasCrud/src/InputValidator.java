import java.util.Scanner;

public class InputValidator {

    public int getIntNumber(Scanner sc, String msg) {
        int num;

        while (true) {
            try {
                System.out.print(msg);
                num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (Exception e) {
                System.out.println("Numero invalido, intenta de nuevo");
                sc.nextLine();
            }
        }
    }
}
