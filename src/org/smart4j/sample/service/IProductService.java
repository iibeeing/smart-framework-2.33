package org.smart4j.sample.service;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.sample.entity.Product;
import org.smart4j.sample.entity.ProductBean;

public interface IProductService {
    List<Product> getProductList();

    Product getProduct(long productId);

    ProductBean getProductBean(long productId);

    boolean createProduct(Map<String, Object> productFieldMap);

    boolean updateProduct(long productId, Map<String, Object> productFieldMap);

    boolean deleteProduct(long productId);

    Pager<ProductBean> searchProductPager(int pageNumber, int pageSize, Map<String, String> formFieldMap);
}
