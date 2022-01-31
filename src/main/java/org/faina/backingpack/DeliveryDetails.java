package org.faina.backingpack;

public class DeliveryDetails {
    String delivery_tracking_number;
    String delivery_carrier_name;
    String return_tracking_number;
    String return_carrier_name;

    public String getDelivery_tracking_number() {
        return delivery_tracking_number;
    }

    public void setDelivery_tracking_number(String delivery_tracking_number) {
        this.delivery_tracking_number = delivery_tracking_number;
    }

    public String getDelivery_carrier_name() {
        return delivery_carrier_name;
    }

    public void setDelivery_carrier_name(String delivery_carrier_name) {
        this.delivery_carrier_name = delivery_carrier_name;
    }

    public String getReturn_tracking_number() {
        return return_tracking_number;
    }

    public void setReturn_tracking_number(String return_tracking_number) {
        this.return_tracking_number = return_tracking_number;
    }

    public String getReturn_carrier_name() {
        return return_carrier_name;
    }

    public void setReturn_carrier_name(String return_carrier_name) {
        this.return_carrier_name = return_carrier_name;
    }

    @Override
    public String toString() {
        return "DeliveryDetails{" +
                "delivery_tracking_number='" + delivery_tracking_number + '\'' +
                ", delivery_carrier_name='" + delivery_carrier_name + '\'' +
                ", return_tracking_number='" + return_tracking_number + '\'' +
                ", return_carrier_name='" + return_carrier_name + '\'' +
                '}';
    }
}
