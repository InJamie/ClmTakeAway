package pers.jamie.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class ProductCategortVo {
    private String name;
    private Integer type;
    private List<ProductInfoVo> foods;


    public ProductCategortVo(String name, Integer type) {
        this.name = name;
        this.type = type;
    }
}
