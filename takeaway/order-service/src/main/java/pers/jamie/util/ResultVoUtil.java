package pers.jamie.util;

import pers.jamie.vo.ResultVo;

import java.util.Collections;

public class ResultVoUtil {

    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg("成功");
        resultVo.setCode(0);
        resultVo.setData(data);
        return resultVo;
    }
    public static ResultVo fail(){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg("失败");
        resultVo.setCode(-1);
        return resultVo;
    }
}
