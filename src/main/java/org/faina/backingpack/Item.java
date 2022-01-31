package org.faina.backingpack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlElement(name = "item")
    String item_id;

    String ean;

    @XmlElement(name = "item_price")
    double price;

    String currency;

    String article_number;

    String zalando_article_number;

    String article_location;

    int return_reason_code;

    String return_location;

    String cancellation_reason;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getArticle_number() {
        return article_number;
    }

    public void setArticle_number(String article_number) {
        this.article_number = article_number;
    }

    public String getZalando_article_number() {
        return zalando_article_number;
    }

    public void setZalando_article_number(String zalando_article_number) {
        this.zalando_article_number = zalando_article_number;
    }

    public String getArticle_location() {
        return article_location;
    }

    public void setArticle_location(String article_location) {
        this.article_location = article_location;
    }

    public int getReturn_reason_code() {
        return return_reason_code;
    }

    public void setReturn_reason_code(int return_reason_code) {
        this.return_reason_code = return_reason_code;
    }

    public String getReturn_location() {
        return return_location;
    }

    public void setReturn_location(String return_location) {
        this.return_location = return_location;
    }

    public String getCancellation_reason() {
        return cancellation_reason;
    }

    public void setCancellation_reason(String cancellation_reason) {
        this.cancellation_reason = cancellation_reason;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id='" + item_id + '\'' +
                ", ean='" + ean + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", article_number='" + article_number + '\'' +
                ", zalando_article_number='" + zalando_article_number + '\'' +
                ", article_location='" + article_location + '\'' +
                ", return_reason_code=" + return_reason_code +
                ", return_location='" + return_location + '\'' +
                ", cancellation_reason='" + cancellation_reason + '\'' +
                '}';
    }
}
