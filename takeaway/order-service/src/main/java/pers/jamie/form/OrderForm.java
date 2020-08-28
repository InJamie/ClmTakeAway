package pers.jamie.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pers.jamie.entity.OrderDetail;

import java.util.List;

@Data
public class OrderForm {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String phone;
    @NotEmpty(message = "地址不能为空")
    private String address;
    @NotEmpty(message = "opentid不能为空")
    private String id;
    @NotEmpty(message = "购物车不能为空")
    private List<OrderDetail> items;

    public void setItems() {
    }
}
