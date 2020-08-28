package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.jamie.entity.OrderDetail;
import pers.jamie.entity.ProductInfo;
import pers.jamie.form.OrderForm;
import pers.jamie.mapper.ProductInfoMapper;
import pers.jamie.service.OrderMasterService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderMasterServiceImplTest {
    @Autowired
    private OrderMasterService orderMasterService;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    void test(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id",5);
        ProductInfo productInfo = productInfoMapper.selectOne(queryWrapper);
        System.out.println(productInfo);
    }

    @Test
    void create() {
        OrderForm orderForm = new OrderForm();
        orderForm.setId("asdadasda");
        orderForm.setPhone("135715929412");
        orderForm.setAddress("长安");
        orderForm.setName("刘宇帆");
        List<OrderDetail> items = new ArrayList<>();

        OrderDetail o = new OrderDetail();
        o.setProductQuantity(5);
        o.setProductId(1);

        items.add(o);
        orderForm.setItems(items);
        orderMasterService.create(orderForm);
    }
}