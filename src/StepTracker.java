import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    int goalByStepsPerDay=10_000;
    MonthData[] monthToData = new MonthData[12];
    Converter converter=new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        String messageWrong = null;
        int month, day=0, steps=0;

        System.out.println("Введите номер месяца");
        month=scanner.nextInt();
        if (!(month>=1&month<=12)){
            messageWrong="Месяц должен быть числом от 1 до 12";
        }

        if (messageWrong==null) {
            System.out.println("Введите день от 1 до 30 (включительно)");
            day = scanner.nextInt();
            if (!(day >= 1 & day <= 30)) {
                messageWrong="День должен быть от 1 до 30 включительно";
            }
        }

        if (messageWrong==null) {
            System.out.println("Введите количество шагов");
            steps  = scanner.nextInt();
            if (!(steps>0)){
                messageWrong="Количество шагов должно быть >0 ";
            }
        }
        if (messageWrong==null) {
            monthToData[month-1].days[day-1]=steps;
        } else {
            System.out.println("Ввели неверные данные: "+ messageWrong);
        }
    }

    void changeStepGoal(){
        System.out.println("Введите количество шагов в день по умолчнию: ");
        int steps  = scanner.nextInt();
        if (!(steps>0)){
            System.out.println("Ввели неверные данные: Количество шагов должно быть положительным числом");
        } else {
            goalByStepsPerDay=steps;
        }
    }

    void printStatistic(){
        System.out.println("Введите число месяца");
        // ввод и проверка номера месяца
        int monthData =scanner.nextInt();
        if (monthData>=1&monthData<=12){

            // получение суммы шагов за месяц
            MonthData m=monthToData[monthData-1];
            int sumSteps=m.sumStepsFromMonth();

            System.out.println("Общая статистика по дням:");
            // вывод общей статистики по дням
            m.printDaysAndStepsFromMonth();
            System.out.println("Сумма шагов за месяц: "+sumSteps);// вывод суммы шагов за месяц
            // вывод максимального пройденного количества шагов за месяц
            System.out.println("Максимальное количество пройденых шагов за месяц: "+ m.maxSteps());
            // вывод среднего пройденного количества шагов за месяц
            System.out.println("Среднее количество пройденных шагов за месяц: "+ sumSteps/m.days.length);
            // вывод пройденной за месяц дистанции в км;
            System.out.println("Пройденнная дистанция за месяц в км: "+converter.convertToKm(sumSteps));
            // вывод количества сожжённых килокалорий за месяц
            System.out.println("Количество сожженных килокалорий за месяц : "+converter.convertStepsToKilocalories(sumSteps));
            // вывод лучшей серии
            System.out.println("Лучшая серия в днях: "+m.bestSeries(goalByStepsPerDay));
            //System.out.println(); //дополнительный перенос строки
        } else {
            System.out.println("Вы указали неверный номер месяца: Месяц должен быть числом от 1 до 12");
        }
    }
} 