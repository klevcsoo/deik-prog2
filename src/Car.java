public class Car {
    private String numberPlate;
    private int performance;
    private boolean automatic;

    public Car(String numberPlate, int performance, boolean automatic) {
        this.numberPlate = numberPlate;
        this.performance = performance;
        this.automatic = automatic;
    }

    public Car() {
        this("KKR-015", 4, false);
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    @Override
    public String toString() {
        return "Car info: %s (performance: %s, transmission: %s)".formatted(
                this.numberPlate,
                this.performance,
                this.automatic ? "automatic" : "manual"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        return performance == ((Car) o).performance;
    }
}
