package top.wdzaslzy.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lizy
 **/
@Controller
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestParam("id") Long id) {
        return "success " + id;
    }

}
