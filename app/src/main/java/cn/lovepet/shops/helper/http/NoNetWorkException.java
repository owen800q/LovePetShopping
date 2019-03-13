package cn.lovepet.shops.helper.http;

/**
 * Created by dingcl.
 */

public class NoNetWorkException extends RuntimeException {
    public NoNetWorkException() {
    }

    public NoNetWorkException(String message) {
        super(message);
    }
}
