package me.ibore.im.handler;

import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.route.RouteHandler;

import java.util.NoSuchElementException;

/**
 * Created by ibore on 2017/7/11.
 */
public class Login extends BaseHandler {
    @Override
    public void handle(Request request, Response response) {
        try {
            Integer uid = request.queryInt("uid").get();
            response.text("uid : " + uid);
        } catch (NoSuchElementException e) {
            response.text("error");
        } finally {

        }

    }
}
