package pers.jamie.vo;

import lombok.Data;

import java.util.List;
@Data
public class PageVo<T> {
    private Long pageSize;
    private Long total;
    private T content;
}
