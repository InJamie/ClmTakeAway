package pers.jamie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.jamie.service.OrderMasterService;
import pers.jamie.util.ResultVoUtil;
import pers.jamie.vo.ResultVo;

@RestController
@RequestMapping("/seller/order")
public class OrderMasterSellerController {

    @Autowired
    private OrderMasterService orderMasterService;

    @GetMapping("/list/{page}/{size}")
    public ResultVo list(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return ResultVoUtil.success(this.orderMasterService.getOrderByPage(page, size));
    }

    @PutMapping("/cancel/{orderId}")
    public ResultVo cancel(@PathVariable("orderId") String orderId){
        boolean result = this.orderMasterService.handler("cancel", orderId);
        if(!result) return ResultVoUtil.fail();
        return ResultVoUtil.success(null);
    }

    @PutMapping("/finish/{orderId}")
    public ResultVo finish(@PathVariable("orderId") String orderId){
        boolean result = this.orderMasterService.handler("finish", orderId);
        if(!result) return ResultVoUtil.fail();
        return ResultVoUtil.success(null);
    }
}
