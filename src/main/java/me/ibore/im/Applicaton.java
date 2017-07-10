package me.ibore.im;

import com.blade.Blade;
import me.ibore.im.handler.Login;

/**
 * Created by ibore on 2017/7/11.
 */
public class Applicaton {
    public static void main(String[] args) {
        Blade blade = Blade.me();
        blade.listen(80);
        blade.post("/", new Login()).start();
    }
}
