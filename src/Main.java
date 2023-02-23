import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StepTracker stepTracker=new StepTracker(scanner);
        boolean isExit=false;
        while (!isExit){
            printMenu();
            switch (scanner.nextInt()){
                case 1://Ввести количество шагов за определённый день
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2://Изменить цель по количеству шагов в день
                    stepTracker.changeStepGoal();
                    break;
                case 3://Напечатать статистику за определённый месяц
                    stepTracker.printStatistic();
                    break;
                case 0:
                    System.out.println("Пока!");
                    scanner.close();
                    isExit=true;
                    break;
                default:
                    System.out.println("Такой команды нет");
            }
        }

    }

    static void printMenu(){
        System.out.println();
        System.out.println("Для выбора действий введите число, соотвествующее пункту меню:");
        System.out.println("-------------------------------------------------------------");
        System.out.println("1: Ввести количество шагов за определённый день");
        System.out.println("2: Изменить цель по количеству шагов в день");
        System.out.println("3: Напечатать статистику за определённый месяц");
        System.out.println("0: <Выход из программы>");
    }
}
