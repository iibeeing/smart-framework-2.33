package org.smart4j.sample.entity;

import org.smart4j.framework.base.BaseEntity;
import org.smart4j.framework.orm.annotation.Entity;

@SuppressWarnings("serial")
@Entity
public class ProductType extends BaseEntity {

    private String productTypeName;

    private String productTypeCode;

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }
}
