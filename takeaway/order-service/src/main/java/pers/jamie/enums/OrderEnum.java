package pers.jamie.enums;

import lombok.Getter;

@Getter
public enum OrderEnum {
    ORDER_PARAM_ERROR(0,"订单参数异常"),
    ORDER_CREATE_FAIL(1,"订单创建失败"),
    PRODUCT_NOT_EXIST(2,"商品不存在"),
    ORDER_NOT_EXIST(3,"订单不存在"),
    ORDER_STATUS_ERROR(4,"订单状态异常"),
    PAY_STATUS_kERROR(5,"支付状态异常");

    OrderEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;
}
