package oauthservice.oauthservice.support;

import lombok.Data;

/**
 * Created by xuh
 * DATE 2019/1/22 22:52.
 * version 1.0
 */
@Data
public class SimpleResponse {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

}
