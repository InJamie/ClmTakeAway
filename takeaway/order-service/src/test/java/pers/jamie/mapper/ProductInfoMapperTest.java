package pers.jamie.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductInfoMapperTest {


    @Autowired
    private ProductInfoMapper productInfoMapper ;

    @Test
    void getPriceById() {
        System.out.println(productInfoMapper.getPriceById(1));
    }
}