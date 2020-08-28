package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pers.jamie.entity.ProductCategory;
import pers.jamie.entity.ProductInfo;
import pers.jamie.mapper.ProductCategoryMapper;
import pers.jamie.mapper.ProductInfoMapper;
import pers.jamie.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.jamie.until.Objec2VObject;
import pers.jamie.vo.ProductCategortVo;
import pers.jamie.vo.ProductInfoVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 类目表 服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {


    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategortVo> listVo() {
//        创建ProductCategortVoList
        List<ProductCategortVo> productCategortVoList = new ArrayList<>();
        List<ProductCategory> productCategories = productCategoryMapper.selectList(null);
        for (ProductCategory v1:productCategories
             ) {
            //创建VO并赋值加入到volist中
            ProductCategortVo vo = new ProductCategortVo();
            vo.setName(v1.getCategoryName());
            vo.setType(v1.getCategoryType());
            //查询每个类型的数据并封装好赋给VO的foods
            List<ProductInfoVo> foods = new ArrayList<>();
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("category_type",vo.getType());
            List<ProductInfo> productInfos = productInfoMapper.selectList(wrapper);
            for (ProductInfo vo1 :
                    productInfos) {
                foods.add(Objec2VObject.ProductInfo2ProductInfoVo(vo1));
            }

            vo.setFoods(foods);
            productCategortVoList.add(vo);
        }

        return productCategortVoList;
    }

    @Override
    public List<ProductCategortVo> findAllProductCategory() {
        List<ProductCategory> productCategories = productCategoryMapper.selectList(null);
        List<ProductCategortVo> result = productCategories.stream().map(e -> new ProductCategortVo(e.getCategoryName(), e.getCategoryType())).collect(Collectors.toList());
        return result;
    }
}
