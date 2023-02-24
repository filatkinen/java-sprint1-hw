import java.util.Scanner;

public class Utils {
    /**
     *
     * @param scanner
     * @return Return input int value  or Integer.MIN_VALUE if user typed something not int
     */
    static int inputInt(Scanner scanner){
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        } else {
            scanner.next();
            return Integer.MIN_VALUE;
        }
    }

}
