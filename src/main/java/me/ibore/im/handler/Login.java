package me.ibore.im.handler;

import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.route.RouteHandler;

/**
 * Created by ibore on 2017/7/11.
 */
public class Login implements RouteHandler {
    @Override
    public void handle(Request request, Response response) {
        response.text("你好");
    }
}
