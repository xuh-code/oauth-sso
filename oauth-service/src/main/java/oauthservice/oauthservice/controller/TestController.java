package oauthservice.oauthservice.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author xuh@fitme.ai
 * @date 2019/1/22 14:43
 */
@RestController
@RequestMapping("/users")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);


    @ApiOperation(value = "查询当前用户信息")
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(principal.toString());
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");

        return principal;
    }
}
