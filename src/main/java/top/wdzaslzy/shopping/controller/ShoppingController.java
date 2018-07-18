package top.wdzaslzy.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lizy
 **/
@Controller
@RequestMapping("v1")
public class ShoppingController {

    private Logger logger = LoggerFactory.getLogger("shoppingInfo");
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/log/generate", method = RequestMethod.POST)
    @ResponseBody
    public String generateLog(){
        logger.info("log");
        return "success";
    }

}
