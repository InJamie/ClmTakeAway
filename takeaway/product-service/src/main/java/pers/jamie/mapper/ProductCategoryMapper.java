package pers.jamie.mapper;

import pers.jamie.entity.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.jamie.vo.ProductCategortVo;

import java.util.List;

/**
 * <p>
 * 类目表 Mapper 接口
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {


    public String findNameByType(Integer id);
}
