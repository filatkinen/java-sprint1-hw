public class Converter {

    int convertToKm(int steps){
        return (int) (steps*0.00075);
    }

    int convertStepsToKilocalories(int steps){
        return (int)(steps*0.05);
    }
}
