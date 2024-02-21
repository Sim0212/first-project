public class Converter {
    int convertToKm(int steps) {
        int oneStep = 75;
        int oneKilometer = 100000;
        int distance = (steps * oneStep) / oneKilometer;
        return distance;
    }
    // Не понял как правильно нужно считать дистанцию и килокалории в целочисленных значениях, но как то получилось.
    int convertStepsToKilocalories(int steps) {
        int oneStep = 50;
        int oneKilo = 1000;
        int Kilocalories = (steps * oneStep) / oneKilo;
        return Kilocalories;
    }
}
