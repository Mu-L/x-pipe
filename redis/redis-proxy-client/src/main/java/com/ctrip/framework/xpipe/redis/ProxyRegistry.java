package com.ctrip.framework.xpipe.redis;

import com.ctrip.framework.xpipe.redis.proxy.ProxyResourceManager;
import com.ctrip.framework.xpipe.redis.utils.ProxyUtil;

public class ProxyRegistry {

    public static final String PROXY_KEY_WORD = "PROXY";

    public static boolean registerProxy(String ip, int port, String routeInfo) {
        if (routeInfo != null && routeInfo.startsWith(PROXY_KEY_WORD)) {
            ProxyUtil.getInstance().registerProxy(ip, port, routeInfo);
            return true;
        }
        return false;
    }

    public static ProxyResourceManager unregisterProxy(String ip, int port) throws Exception {
        return ProxyUtil.getInstance().unregisterProxy(ip, port);
    }

}
