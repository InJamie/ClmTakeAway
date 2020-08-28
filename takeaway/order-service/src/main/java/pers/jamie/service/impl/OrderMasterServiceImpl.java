package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.jamie.Exception.OrderException;
import pers.jamie.entity.OrderDetail;
import pers.jamie.entity.OrderMaster;
import pers.jamie.entity.ProductInfo;
import pers.jamie.enums.OrderEnum;
import pers.jamie.fegin.Fegin;
import pers.jamie.form.OrderForm;
import pers.jamie.mapper.OrderDetailMapper;
import pers.jamie.mapper.OrderMasterMapper;
import pers.jamie.mapper.ProductInfoMapper;
import pers.jamie.service.OrderMasterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.jamie.util.OrderFormToOrderMaster;
import pers.jamie.vo.OrderVO;
import pers.jamie.vo.PageVO;
import pers.jamie.vo.ResultVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
@Service
@Slf4j

public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements OrderMasterService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private Fegin fegin;

    @Override
    public String create(OrderForm orderForm) {
//      获取传进信息 封装成OrderMaster并存储到数据库
        OrderMaster orderMaster = OrderFormToOrderMaster.transfor(orderForm);;
//      根据item中的quanlity和id查询商品价格并计算赋给orderMaster.setOrderAmount
        List<OrderDetail> items = orderForm.getItems();
        BigDecimal amount = new BigDecimal(0);
        for (OrderDetail item : items) {
            amount = amount.add(productInfoMapper.getPriceById(item.getProductId()).multiply(new BigDecimal(item.getProductQuantity())));
//            减库存
            this.fegin.subStock(item.getProductId(),item.getProductQuantity());
        }
        orderMaster.setOrderAmount(amount);
        int resunlt = orderMasterMapper.insert(orderMaster);

//        添加订单详情
        for (OrderDetail item : items) {
            //保存订单详情
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderMaster.getOrderId());
            ProductInfo productInfo = this.productInfoMapper.selectById(item.getProductId());
            orderDetail.setProductQuantity(item.getProductQuantity());
            orderDetail.setProductId(item.getProductId());
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetail.setProductName(productInfo.getProductName());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            this.orderDetailMapper.insert(orderDetail);
        }

        if (resunlt==1)return orderMaster.getOrderId();
        return null;
    }

    @Override
    public OrderVO getVOByBuyerIdAndOrderId(String buyerId, String orderId) {
        OrderVO orderVO = new OrderVO();
//       获取订单信息
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("buyer_openid", buyerId);
        wrapper.eq("order_id", orderId);
        OrderMaster orderMaster = orderMasterMapper.selectOne(wrapper);
        BeanUtils.copyProperties(orderMaster,orderVO);
//        获取订单详情
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("order_id", orderId);
        orderVO.setOrderDetailList(orderDetailMapper.selectList(wrapper1));
        return orderVO;
    }

    @Override
    public List<OrderVO> getVOListByBuyerId(String buyerId, Integer current, Integer size) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("buyer_openid",buyerId);
        Page<OrderMaster> orderMasterPage = new Page<>(current,size);
        Page<OrderMaster> result = this.orderMasterMapper.selectPage(orderMasterPage, wrapper);
        List<OrderMaster> list = result.getRecords();
        List<OrderVO> orderVOList = new ArrayList<>();
        OrderVO orderVO = null;
        for (OrderMaster orderMaster : list) {
            orderVO = new OrderVO();
            BeanUtils.copyProperties(orderMaster, orderVO);
            orderVOList.add(orderVO);
        }
        return orderVOList;

    }

    @Override
    public Boolean cancel(String buyerId, String orderId) {
        if (orderMasterMapper.cancel(buyerId, orderId)==1)
        return true;
        return false;
    }

    @Override
    public Boolean finish(String orderId) {
        Integer finish = orderMasterMapper.finish(orderId);
        if (finish==1)return true;
        return false;

    }

    @Override
    public Boolean pay(String buyerId, String orderId) {
        Integer pay = orderMasterMapper.pay(buyerId, orderId);
        if (pay==1)return true;
        return false;
    }


    @Override
    public PageVO<List<OrderMaster>> getOrderByPage(Integer page, Integer size) {
        Page<OrderMaster> condition = new Page<>(page,size);
        Page<OrderMaster> result = this.orderMasterMapper.selectPage(condition, null);
        PageVO<List<OrderMaster>> pageVO = new PageVO<>();
        pageVO.setContent(result.getRecords());
        pageVO.setSize(result.getSize());
        pageVO.setTotal(result.getTotal());
        return pageVO;
    }

    @Override
    public boolean handler(String type, String orderId) {
        OrderMaster orderMaster = this.orderMasterMapper.selectById(orderId);
        if(orderMaster.getOrderStatus() != 0){
            log.info("【处理订单】，订单状态异常，orderMaster={}", orderMaster);
            throw new OrderException(OrderEnum.ORDER_STATUS_ERROR);
        }
        int row = 0;
        switch (type){
            case "cancel":
                row = this.orderMasterMapper.handler(2, orderId);
                break;
            case "finish":
                row = this.orderMasterMapper.handler(1, orderId);
                break;
        }
        if(row == 1) return true;
        return false;
    }
}
