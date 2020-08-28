package pers.jamie.service;

import pers.jamie.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.jamie.vo.ProductCategortVo;

import java.util.List;

/**
 * <p>
 * 类目表 服务类
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    public List<ProductCategortVo> listVo();

    public List<ProductCategortVo> findAllProductCategory();


}
