/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 14 - Car Class
 */

public class Car {

    private String manufacturer;
    private String model;
    private int    year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "{" + manufacturer + " " + model + " " + year + "}";
    }
}
