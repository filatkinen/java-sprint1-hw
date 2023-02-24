import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    int goalByStepsPerDay;
    MonthData[] monthToData;
    Converter converter;

    StepTracker(Scanner scanner) {
        this.scanner = scanner;
        setStepTracker();
    }
    void setStepTracker(){
        goalByStepsPerDay=10_000;
        monthToData = new MonthData[12];
        converter=new Converter();
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }

    }
    void addNewNumberStepsPerDay() {
        String wrongMessage=null;
        int month, day=0, steps=0;
        boolean wrongInput=false;

        System.out.println("Введите номер месяца");
        month=Utils.inputInt(scanner);
        if (!(month>=1&month<=12)){
            wrongInput=true;
            wrongMessage ="Месяц должен быть числом от 1 до 12";
        }

        if (!wrongInput) {
            System.out.println("Введите день от 1 до 30 (включительно)");
            day = Utils.inputInt(scanner);
            if (!(day >= 1 & day <= 30)) {
                wrongInput=true;
                wrongMessage ="День должен быть от 1 до 30 включительно";
            }
        }

        if (!wrongInput) {
            System.out.println("Введите количество шагов");
            steps  = Utils.inputInt(scanner);
            if (!(steps>0)){
                wrongInput=true;
                wrongMessage ="Количество шагов должно быть >0 ";
            }
        }
        if (!wrongInput) {
            monthToData[month-1].days[day-1]=steps;
        } else {
            System.out.println("Ввели неверные данные: "+ wrongMessage);
        }
    }

    void changeStepGoal(){
        System.out.println("Введите количество шагов в день по умолчнию: ");
        int steps  = Utils.inputInt(scanner);
        if (!(steps>0)){
            System.out.println("Ввели неверные данные: Количество шагов должно быть положительным числом");
        } else {
            goalByStepsPerDay=steps;
        }
    }

    void printStatistic(){
        System.out.println("Введите число месяца");
        // ввод и проверка номера месяца
        int monthData =Utils.inputInt(scanner);
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