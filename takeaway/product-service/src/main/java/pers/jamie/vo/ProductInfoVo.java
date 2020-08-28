package pers.jamie.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfoVo {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String descriprion;
    private String icon;
    private Integer quantity;
    private Integer stock;
}
