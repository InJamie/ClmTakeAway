package pers.jamie.controller;


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pers.jamie.entity.ProductCategory;
import pers.jamie.service.ProductCategoryService;
import pers.jamie.vo.ProductCategortVo;
import pers.jamie.vo.ResultVo;

import java.util.List;

/**
 * <p>
 * 类目表 前端控制器
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
@RestController
@RequestMapping("//productCategory")
@Slf4j
public class ProductCategoryBuyerController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("list")
    public List<ProductCategory> list(){
        return productCategoryService.list();
    }

    @RequestMapping("listvo")
    public ResultVo<ProductCategortVo> listvo(){
        log.info("调用了{}的服务",port);
        ResultVo resultVo = new ResultVo();
        resultVo.setData(productCategoryService.listVo());
        return resultVo;
    }



}

