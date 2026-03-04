import java.io.Serializable;

public class CalculationData implements java.io.Serializable {
    private transient long calculationTime;

    public void setCalculationTime(long calculationTime) {
        this.calculationTime = calculationTime;
    }

    public long getCalculationTime() {
        return calculationTime;
    }
    private static final long serialVersionUID = 1L;

    /** Катет A */
    private double a;

    /** Катет B */
    private double b;

    /** Результат обчислення */
    private double result;

    /** * Час проведення обчислення.
     * Ключове слово transient означає, що це поле не буде серіалізовано.
     */
    private transient long calculationT;

    /**
     * Конструктор для ініціалізації початкових параметрів.
     * @param a довжина першого катета
     * @param b довжина другого катета
     */
    public CalculationData(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
    public long getCal() { return calculationT; }
    public void setCal(long calculationT) { this.calculationT = calculationT; }


    @Override
    public String toString() {
        return "CalculationData{" +
                "a=" + a +
                ", b=" + b +
                ", result=" + result +
                ", calculationTime=" + calculationT +
                " (якщо 0, дані десеріалізовано)" +
                '}';
    }
}
