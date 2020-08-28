package pers.jamie.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;
}
