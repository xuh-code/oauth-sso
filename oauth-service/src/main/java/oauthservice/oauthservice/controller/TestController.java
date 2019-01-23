package oauthservice.oauthservice.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author xuh@fitme.ai
 * @date 2019/1/22 14:43
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class TestController {

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id){
        return "order id : " + id;
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(principal.toString());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");

        return principal;
    }
}
