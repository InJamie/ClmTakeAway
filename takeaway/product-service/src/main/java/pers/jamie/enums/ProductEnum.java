package pers.jamie.enums;

import lombok.Getter;

@Getter
public enum ProductEnum {
    PRODUCT_STOCK_ERROR(0,"商品库存不足")
    ;


    ProductEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;
}
