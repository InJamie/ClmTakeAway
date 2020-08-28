package pers.jamie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pers.jamie.entity.ProductInfo;
import pers.jamie.service.ProductInfoService;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
@RestController
@RequestMapping("//productInfo")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("/list")
    public List<ProductInfo> list(){
        return productInfoService.list();
    }

    @RequestMapping("/subStock/{id}/{quantity}")
    public boolean subStock(@PathVariable("id") Integer id,@PathVariable("quantity") Integer quantity){
        return productInfoService.subStock(id, quantity);
    }


}

