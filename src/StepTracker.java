public class StepTracker {
    int targetSteps = 10000;
    MonthData[] monthToData;



    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void saveSteps(int monthNumber, int dayNumber, int stepsAmount) {
        monthToData[monthNumber].insertSteps(dayNumber, stepsAmount);
    }

    void print(int monthNumber) {
        MonthData currentMonth = monthToData[monthNumber];
        int stepsSum = 0;
        int maxSteps = 0;

        for (int i = 0; i < currentMonth.saveDays.length; i++) {
            System.out.println(i + " день, " + currentMonth.saveDays[i] + " шагов.");
            stepsSum += currentMonth.saveDays[i];
            if (maxSteps < currentMonth.saveDays[i]) {
                maxSteps = currentMonth.saveDays[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Общее количество шагов за месяц: " + stepsSum);
        System.out.println("Среднее количество шагов за месяц: " + stepsSum / 30);
        System.out.println("Пройденная дистанция (в км): " + Converter.convertDistance(stepsSum));
        System.out.println("Количество сожжённых килокалорий: " + Converter.convertCalories(stepsSum));
        System.out.println("Лучшая серия: " + currentMonth.findBestRange(targetSteps));
    }

    void setTargetSteps(int target) {
        targetSteps = target;
    }



    class MonthData {
        int[] saveDays;

        public MonthData() {
            saveDays = new int[30];
        }

        void insertSteps(int dayNumber, int stepsAmount) {
            saveDays[dayNumber] = stepsAmount;
        }

        int findBestRange(int target) {
            int maxRange = 0;
            int currentRange = 0;
            for (int i = 0; i < saveDays.length; i++) {
                int currentDaySteps = saveDays[i];

                if (currentDaySteps >= target) {
                    currentRange++;

                    if (currentRange > maxRange) {
                        maxRange = currentRange;
                    }
                }
                else {
                    currentRange = 0;
                }
            }
            return maxRange;
        }
    }
}

