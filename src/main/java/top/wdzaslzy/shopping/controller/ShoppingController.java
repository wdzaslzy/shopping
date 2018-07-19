package top.wdzaslzy.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wdzaslzy.shopping.service.GenerateLogService;

/**
 * @author lizy
 **/
@Controller
@RequestMapping("v1")
public class ShoppingController {

    @Autowired
    private GenerateLogService generateLogService;

    @RequestMapping(value = "/log/generate/shopping", method = RequestMethod.GET)
    @ResponseBody
    public String generateShoppingLog() {
        generateLogService.generateAddShoppingCartLog();
        return "success";
    }

    @RequestMapping(value = "log/generate/collection", method = RequestMethod.GET)
    @ResponseBody
    public String generateCollectionLog() {
        generateLogService.generateCollectGoodsLog();
        return "success";
    }

}
