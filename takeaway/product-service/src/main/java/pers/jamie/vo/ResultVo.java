package pers.jamie.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResultVo<T> {
    private Integer code = 0;
    private String msg = "成功";
    private T data;
}
