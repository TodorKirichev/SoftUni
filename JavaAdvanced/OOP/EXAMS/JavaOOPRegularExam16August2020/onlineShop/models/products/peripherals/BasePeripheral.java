package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.peripherals;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {
    private String connectionType;
    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Connection Type: %s", connectionType);
    }
}
