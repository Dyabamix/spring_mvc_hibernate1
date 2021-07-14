package web.models;

public class Car {
    private String model;
    private int series;
    private String serialnumber;

    public Car() {}

    public Car(String model, int series, String serialnumber) {
        this.model = model;
        this.series = series;
        this.serialnumber = serialnumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

}
