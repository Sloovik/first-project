/**
 * Класс для конвертации шагов.
 */
public class Converter {

    /**
     * Конвертирует шаги в километры.
      * @param steps количество шагов.
     * @return количество километров.
     */
    static double convertDistance(int steps) {
        return (double) (steps * 75 / 100000);
    }

    static double convertCalories(int steps) {
        return (double) (steps * 50 / 1000);
    }
}
