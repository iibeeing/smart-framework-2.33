package org.smart4j.sample.entity;

import org.smart4j.framework.base.BaseEntity;
import org.smart4j.framework.orm.annotation.Entity;

@SuppressWarnings("serial")
@Entity
public class Product extends BaseEntity {

    private long productTypeId;

    private String productName;

    private String productCode;

    private int price;

    private String description;

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
