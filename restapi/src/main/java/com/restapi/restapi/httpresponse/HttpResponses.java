package com.restapi.restapi.httpresponse;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class HttpResponses {

    private final static String RESPONSE_STATUS = "STATUS";
    private final static String RESPONSE_MSG = "msg";
    private final static String RESPONSE_MSGDESC = "msgDesc";
    private final static String RESPONSE_DATA = "data";

    public String httpResponses(Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(RESPONSE_STATUS, 0);
        map.put(RESPONSE_MSG, "CREATED");
        map.put(RESPONSE_DATA, data);
        return new Gson().toJson(map);
    }

    public String httpResponses(String err, String desc, int responseCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(RESPONSE_STATUS, 1);
        map.put(RESPONSE_MSG, err);
        map.put(RESPONSE_MSGDESC, desc);
        map.put("httpResponseCode", responseCode);
        return new Gson().toJson(map);
    }

}
