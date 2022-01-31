package org.faina.backingpack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
Pack to be return
 */
@XmlRootElement
public class Order {
    // @XmlElement(name = "nice_event_id")  // use in case of need to change the tag name
    String event_id;

    String order_id;

    String order_number;

    String state;

    String store_id;

    String timestamp;

    DeliveryDetails delivery_details;

    CustomerBillingAddress customer_billing_address;

    ArrayList<Item> items;

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public DeliveryDetails getDelivery_details() {
        return delivery_details;
    }

    public void setDelivery_details(DeliveryDetails delivery_details) {
        this.delivery_details = delivery_details;
    }

    public CustomerBillingAddress getCustomer_billing_address() {
        return customer_billing_address;
    }

    public void setCustomer_billing_address(CustomerBillingAddress customer_billing_address) {
        this.customer_billing_address = customer_billing_address;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "event_id='" + event_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", order_number=" + order_number +
                ", state='" + state + '\'' +
                ", store_id=" + store_id +
                ", timestamp='" + timestamp + '\'' +
                ", delivery_details=" + delivery_details +
                ", customer_billing_address=" + customer_billing_address +
                ", items=" + items +
                '}';
    }
}
