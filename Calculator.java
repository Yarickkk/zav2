public class Calculator {


    /** Об'єкт даних, над яким проводяться обчислення */
    private CalculationData data;

    public Calculator(CalculationData data) {
        this.data = data;
    }

    /**
     * Виконує обчислення гіпотенузи за теоремою Піфагора.
     * Результат та час виконання записуються в об'єкт даних.
     */
    public void calculate() {
        double result = Math.sqrt(Math.pow(data.getA(), 2) + Math.pow(data.getB(), 2));
        data.setResult(result);
        data.setCalculationTime(System.currentTimeMillis());
    }
}
