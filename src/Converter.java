public class Converter {

    int convertToKm(int steps){
        return steps*75/100/1_000;
    }

    int convertStepsToKilocalories(int steps){
        return steps*50/1_000;
    }
}
