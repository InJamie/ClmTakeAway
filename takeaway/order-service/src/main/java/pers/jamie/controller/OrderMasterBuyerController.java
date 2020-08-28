package pers.jamie.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pers.jamie.form.OrderForm;
import pers.jamie.service.OrderMasterService;
import pers.jamie.util.ResultVoUtil;
import pers.jamie.vo.OrderVO;
import pers.jamie.vo.ResultVo;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author Jamie
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class OrderMasterBuyerController {

    @Autowired
    private OrderMasterService orderMasterService;

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.info("【创建订单】,参数异常,orderForm={}", orderForm);
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(orderForm);
//        进行逻辑操作
        String data = orderMasterService.create(orderForm);
        if (data==null){
            log.info("【创建订单】,创建订单失败,orderForm={}", orderForm);
            return ResultVoUtil.fail();
        }
        System.out.println(ResultVoUtil.success(data));
        return ResultVoUtil.success(data);
    }

    @GetMapping("/list/{buyerId}/{page}/{size}")
    public ResultVo list(
            @PathVariable("buyerId")String buyerId,
            @PathVariable("page")Integer page,
            @PathVariable("size")Integer size
    ){
        List<OrderVO> voListByBuyerId = orderMasterService.getVOListByBuyerId(buyerId, page, size);
        return ResultVoUtil.success(voListByBuyerId);
    }

    @GetMapping("/detail/{buyerId}/{orderId}")
    public ResultVo detail(@PathVariable("buyerId")String buyerId,
                           @PathVariable("orderId")String orderId
                           ){
        return ResultVoUtil.success(orderMasterService.getVOByBuyerIdAndOrderId(buyerId, orderId));
    }

    @PostMapping("/cancel/{buyerId}/{orderId}")
    public ResultVo cancel(@PathVariable("buyerId")String buyerId,
                           @PathVariable("orderId")String orderId
    ){
        Boolean cancel = orderMasterService.cancel(buyerId, orderId);
        if (cancel)return ResultVoUtil.success(null);
        return ResultVoUtil.fail();
    }


    @PostMapping("/finish/{orderId}")
    public ResultVo finish(
            @PathVariable("orderId")String orderId
    ){
        Boolean finish = orderMasterService.finish(orderId);
        if (finish)return ResultVoUtil.success(null);
        return ResultVoUtil.fail();
    }


    @PostMapping("/pay/{buyerId}/{orderId}")
    public ResultVo pay(@PathVariable("buyerId")String buyerId,
                           @PathVariable("orderId")String orderId){

        Boolean finish = orderMasterService.pay(buyerId, orderId);
        if (finish)return ResultVoUtil.success(null);
        return ResultVoUtil.fail();
    }


}

