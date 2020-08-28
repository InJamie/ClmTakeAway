package pers.jamie.service;

import pers.jamie.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.jamie.vo.PageVo;
import pers.jamie.vo.ProductMasterVo;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
public interface ProductInfoService extends IService<ProductInfo> {
    public boolean subStock(Integer productId,Integer quantity);
    public PageVo findProductManageVOByPage(Integer page,Integer size);
    public ProductMasterVo findById(Integer id);
    public boolean updateProductManageVO(ProductMasterVo productManageVO);
    public Boolean updateStatus(Integer id,Boolean status);
}
