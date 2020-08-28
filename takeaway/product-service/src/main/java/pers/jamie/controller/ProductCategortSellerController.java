package pers.jamie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.jamie.entity.ProductInfo;
import pers.jamie.service.ProductCategoryService;
import pers.jamie.service.ProductInfoService;
import pers.jamie.until.ResultVoUtil;
import pers.jamie.vo.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seller/product")
public class ProductCategortSellerController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;


    @GetMapping("/findAllProductCategory")
    public ResultVo findAllProductCategory(){
        List<ProductCategortVo> allProductCategory = productCategoryService.findAllProductCategory();
        return ResultVoUtil.success(allProductCategory);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody ProductInfo productInfo){
        boolean save = productInfoService.save(productInfo);
        if (save)
        return ResultVoUtil.success(null);
        return ResultVoUtil.fail();
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVo list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageVo<List<ProductMasterVo>> productManageVOByPage = productInfoService.findProductManageVOByPage(page, size);
        return ResultVoUtil.success(productManageVOByPage);
    }

    @GetMapping("findById/{id}")
    public ResultVo findById(@PathVariable("id") Integer id){
        ProductMasterVo byId = productInfoService.findById(1);
        return ResultVoUtil.success(byId);
    }

    @DeleteMapping("delete/{id}")
    public ResultVo delete(@PathVariable("id") Integer id){
        if (productInfoService.removeById(id))return ResultVoUtil.success(null);
        return ResultVoUtil.fail();
    }

    @PutMapping("updateStatus/{id}/{status}")
    public ResultVo updateStatus(@PathVariable("id") Integer id,@PathVariable("status") Boolean status){
        if (productInfoService.updateStatus(id, status))return ResultVoUtil.success(null);
        return ResultVoUtil.fail();
    }

    @PutMapping("/update")
    public ResultVo update(@RequestBody ProductMasterVo productManageVO){
        System.out.println("11111111111111111111111\n\n"+productManageVO);
        boolean result = this.productInfoService.updateProductManageVO(productManageVO);
        if(!result) return ResultVoUtil.fail();
        return ResultVoUtil.success(null);
    }


    }
