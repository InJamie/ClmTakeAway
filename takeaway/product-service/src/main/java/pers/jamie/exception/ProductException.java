package pers.jamie.exception;

import pers.jamie.enums.ProductEnum;

public class ProductException extends RuntimeException {
    public ProductException(ProductEnum productEnum) {
        super(productEnum.getMsg());
    }
}
