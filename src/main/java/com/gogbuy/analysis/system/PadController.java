package com.gogbuy.analysis.system;

import com.gogbuy.analysis.system.websocket.CalcInput;
import com.gogbuy.analysis.system.websocket.Result;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mr.Yangxiufeng on 2016/5/26.
 */
@Controller
public class PadController {
    @RequestMapping(value = "/pad",method = RequestMethod.GET)
    public ModelAndView Hello(ModelAndView modelAndView){
        modelAndView.setViewName("pad");
        return modelAndView;
    }
    @MessageMapping("/add" )
    @SendTo("/makePair/showResult")
    public Result addNum(CalcInput input) throws Exception {
        System.out.println(input.toString());
        Thread.sleep(2000);
        Result result = new Result(input.getNum1()+"+"+input.getNum2()+"="+(input.getNum1()+input.getNum2()));
        return result;
    }
}
