package pers.jamie.Exception;

import pers.jamie.enums.OrderEnum;

public class OrderException extends RuntimeException {
    public OrderException(OrderEnum orderEnum) {
        super(orderEnum.getMsg());
    }
}
