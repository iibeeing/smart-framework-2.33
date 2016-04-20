package org.smart4j.sample.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.smart4j.framework.base.BaseService;
import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.framework.tx.annotation.Transaction;
import org.smart4j.framework.util.MapUtil;
import org.smart4j.framework.util.StringUtil;
import org.smart4j.sample.entity.Product;
import org.smart4j.sample.entity.ProductBean;
import org.smart4j.sample.entity.ProductType;
import org.smart4j.sample.service.IProductService;

@Service
public class ProductServiceImpl extends BaseService implements IProductService {

    @Override
    public List<Product> getProductList() {
    	return DataSet.selectListWithSort(Product.class, "id asc");
    }

    @Override
    public Product getProduct(long productId) {
        return DataSet.select(Product.class, "id = ?", productId);
    }

    @Override
    public ProductBean getProductBean(long productId) {
        ProductBean productBean = null;
        Product product = DataSet.select(Product.class, "id = ?", productId);
        if (product != null) {
            ProductType productType = DataSet.select(ProductType.class, "id = ?", product.getProductTypeId());
            if (productType != null) {
                productBean = new ProductBean(product, productType);
            }
        }
        return productBean;
    }

    @Override
    @Transaction
    public boolean createProduct(Map<String, Object> fieldMap) {
        return DataSet.insert(Product.class, fieldMap);
    }

    @Override
    @Transaction
    public boolean updateProduct(long productId, Map<String, Object> fieldMap) {
        return DataSet.update(Product.class, fieldMap, "id = ?", productId);
    }

    @Override
    @Transaction
    public boolean deleteProduct(long productId) {
        return DataSet.delete(Product.class, "id = ?", productId);
    }

    @Override
    public Pager<ProductBean> searchProductPager(int pageNumber, int pageSize, Map<String, String> queryMap) {
        String where = "";
        if (MapUtil.isNotEmpty(queryMap)) {
            String productName = queryMap.get("productName");
            if (StringUtil.isNotEmpty(productName)) {
                where += "product_name like '%" + productName + "%'";
            }
        }

        String sort = "id asc";

        long totalRecord = DataSet.selectCount(Product.class, where);
        List<Product> productList = DataSet.selectListForPager(pageNumber, pageSize, Product.class, where, sort);

        List<ProductBean> productBeanList = new ArrayList<ProductBean>();
        Map<Long, ProductType> productTypeMap = DataSet.selectMap(ProductType.class);
        for (Product product : productList) {
            ProductType productType = productTypeMap.get(product.getProductTypeId());
            if (productType != null) {
                productBeanList.add(new ProductBean(product, productType));
            }
        }

        return new Pager<ProductBean>(pageNumber, pageSize, totalRecord, productBeanList);
    }
}
