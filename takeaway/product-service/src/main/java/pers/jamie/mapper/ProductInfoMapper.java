package pers.jamie.mapper;

import pers.jamie.entity.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    public Integer updateStatus(Integer id,Boolean status);


}
