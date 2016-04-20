package org.smart4j.sample.action;

import java.util.Map;

import org.smart4j.framework.base.BaseAction;
import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.util.CastUtil;
import org.smart4j.framework.util.WebUtil;
import org.smart4j.sample.entity.ProductBean;
import org.smart4j.sample.service.IProductService;

@Action
public class ProductAction extends BaseAction {

    @Inject
    private IProductService productService;

    @Request.Get("/product")
    public Result index() {
        Pager<ProductBean> productBeanPager = productService.searchProductPager(1, 10, null);
        return new Result(true).data(productBeanPager);
    }

    @Request.Post("/product/search")
//    public Result search(Map<String, Object> fieldMap) {
    public Result search(Params params) {
    	Map<String,Object> fieldMap = params.getFieldMap();
        int pageNumber = CastUtil.castInt(fieldMap.get(PAGE_NUMBER));
        int pageSize = CastUtil.castInt(fieldMap.get(PAGE_SIZE));
        String queryString = CastUtil.castString(fieldMap.get(QUERY_STRING));
        Map<String, String> queryMap = WebUtil.createQueryMap(queryString);
        Pager<ProductBean> productBeanPager = productService.searchProductPager(pageNumber, pageSize, queryMap);
        return new Result(true).data(productBeanPager);
    }

    @Request.Get("/product/view/{id}")
    public Result view(long id) {
        if (id == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        ProductBean productBean = productService.getProductBean(id);
        if (productBean != null) {
            return new Result(true).data(productBean);
        } else {
            return new Result(false).error(ERROR_DATA);
        }
    }

    @Request.Post("/product/create")
    public Result create(Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean success = productService.createProduct(fieldMap);
        return new Result(success);
    }

    @Request.Put("/product/update/{id}")
    public Result update(long id, Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        if (id == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        boolean success = productService.updateProduct(id, fieldMap);
        return new Result(success);
    }

    @Request.Delete("/product/delete/{id}")
    public Result delete(long id) {
        if (id == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        boolean success = productService.deleteProduct(id);
        return new Result(success);
    }
}
