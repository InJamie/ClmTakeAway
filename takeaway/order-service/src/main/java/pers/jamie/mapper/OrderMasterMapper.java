package pers.jamie.mapper;

import pers.jamie.entity.OrderMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {

    public Integer cancel (String buyerId, String orderId);
    public Integer pay(String buyerId, String orderId);
    public Integer finish(String orderId);
    public int handler(Integer status,String orderId);

}
