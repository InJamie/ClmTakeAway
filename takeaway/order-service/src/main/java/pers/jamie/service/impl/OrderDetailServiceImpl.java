package pers.jamie.service.impl;

import pers.jamie.entity.OrderDetail;
import pers.jamie.mapper.OrderDetailMapper;
import pers.jamie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
