package oauthservice.oauthservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuh@fitme.ai
 * @date 2019/1/22 14:43
 */
@RestController
public class TestController {

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id){
        return "order id : " + id;
    }

}
