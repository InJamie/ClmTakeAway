package pers.jamie.service;

import org.springframework.web.bind.annotation.PathVariable;
import pers.jamie.entity.OrderMaster;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.jamie.form.OrderForm;
import pers.jamie.vo.OrderVO;
import pers.jamie.vo.PageVO;
import pers.jamie.vo.ResultVo;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
public interface OrderMasterService extends IService<OrderMaster> {

    public String create(OrderForm orderForm);

    public OrderVO getVOByBuyerIdAndOrderId(String buyerId, String orderId);
    public List<OrderVO> getVOListByBuyerId(String buyerId, Integer current, Integer size);
    public Boolean cancel(String buyerId, String orderId);
    public Boolean finish(String orderId);
    public Boolean pay(String buyerId, String orderId);

    public PageVO<List<OrderMaster>> getOrderByPage(Integer page, Integer size);
    //卖家端处理订单接口
    public boolean handler(String type,String orderId);

}
