package pers.jamie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pers.jamie.entity.ProductCategory;

import java.math.BigDecimal;

@Data
public class ProductMasterVo {
    @JsonProperty("id")
    private Integer productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("stock")
    private Integer productStock;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
    private Boolean status;

    private String categoryName;
    private ProductCategory category;
}
