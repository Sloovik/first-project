/**
 * Класс для конвертации шагов.
 */
public class Converter {

    /**
     * Конвертирует шаги в километры.
     *
     * @param steps количество шагов.
     * @return количество километров.
     */
    static int convertDistance(int steps) {
        return steps * 75 / 100000;
    }

    /**
     * Конвертирует шаги в сожженные килокалории.
     *
     * @param steps количество шагов.
     * @return количество сожженных килокалорий.
     */
    static int convertCalories(int steps) {
        return steps * 50 / 1000;
    }
}
