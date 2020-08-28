package pers.jamie.until;

import pers.jamie.entity.ProductInfo;
import pers.jamie.vo.ProductInfoVo;

/**
 * 讲普通类转换成Vo的工具类
 */
public class Objec2VObject {

    public static ProductInfoVo ProductInfo2ProductInfoVo(ProductInfo productInfo){
        ProductInfoVo vo = new ProductInfoVo();
        vo.setName(productInfo.getProductName());
        vo.setId(productInfo.getProductId());
        vo.setPrice(productInfo.getProductPrice());
        vo.setDescriprion(productInfo.getProductDescription());
        vo.setIcon(productInfo.getProductIcon());
        vo.setStock(productInfo.getProductStock());
         vo.setQuantity(0);
        return vo;
    };
}
