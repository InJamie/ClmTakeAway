package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.jamie.entity.ProductCategory;
import pers.jamie.entity.ProductInfo;
import pers.jamie.enums.ProductEnum;
import pers.jamie.exception.ProductException;
import pers.jamie.mapper.ProductCategoryMapper;
import pers.jamie.mapper.ProductInfoMapper;
import pers.jamie.service.ProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.jamie.vo.PageVo;
import pers.jamie.vo.ProductMasterVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public boolean subStock(Integer productId, Integer quantity) {
        ProductInfo productInfo = productInfoMapper.selectById(productId);
        Integer productStock = productInfo.getProductStock();
        Integer result = productStock -quantity;
        if (result<0){
            throw new ProductException(ProductEnum.PRODUCT_STOCK_ERROR);
        }
        productInfo.setProductStock(result);
        int i = productInfoMapper.updateById(productInfo);
        if (i==1) return true;
        return false;
    }

    @Override
    public PageVo<List<ProductMasterVo>> findProductManageVOByPage(Integer page, Integer size) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductInfo> condition = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page,size);
        Page<ProductInfo> productInfoPage = this.productInfoMapper.selectPage(condition, null);
        List<ProductInfo> productInfoList = productInfoPage.getRecords();
        PageVo<List<ProductMasterVo>> pageVo = new PageVo<>();
        List<ProductMasterVo> productManageVOList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            ProductMasterVo productManageVO = new ProductMasterVo();
            BeanUtils.copyProperties(productInfo, productManageVO);
            //status
            if(productInfo.getProductStatus() == 0) productManageVO.setStatus(false);
            else productManageVO.setStatus(true);
            //categoryName
            productManageVO.setCategoryName(this.productCategoryMapper.findNameByType(productInfo.getCategoryType()));
            productManageVOList.add(productManageVO);
        }
        PageVo<List<ProductMasterVo>> result = new PageVo<>();
        result.setContent(productManageVOList);
        result.setPageSize(productInfoPage.getSize());
        result.setTotal(productInfoPage.getTotal());
        return result;


    }

    @Override
    public ProductMasterVo findById(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("product_id",id);
        ProductInfo productInfo = productInfoMapper.selectOne(wrapper);
        ProductMasterVo pageVo = new ProductMasterVo();
        BeanUtils.copyProperties(productInfo, pageVo);
        if(productInfo.getProductStatus() == 0) pageVo.setStatus(false);
        else pageVo.setStatus(true);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(productInfo.getCategoryType());
        pageVo.setCategory(productCategory);
        return pageVo;
    }

    @Override
    public Boolean updateStatus(Integer id,Boolean status){
        Integer integer = productInfoMapper.updateStatus(id, status);
        if (integer==1)return true;
        return false;
    }

    @Override
    public boolean updateProductManageVO(ProductMasterVo productManageVO) {
        ProductInfo productInfo = this.productInfoMapper.selectById(productManageVO.getProductId());
        BeanUtils.copyProperties(productManageVO, productInfo);
        productInfo.setCategoryType(productManageVO.getCategory().getCategoryType());
        if(productManageVO.getStatus()) productInfo.setProductStatus(1);
        else productInfo.setProductStatus(0);
        int row = this.productInfoMapper.updateById(productInfo);
        if(row == 1) return true;
        return false;
    }
}
