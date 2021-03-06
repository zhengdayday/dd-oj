package com.ddoj.web.security;

import java.util.Set;

/**
 * @author zhengtt
 **/
public class SessionHelper {
    private static ThreadLocal<UserSession> threadLocal = new ThreadLocal<>();

    public static UserSession get() {
        return threadLocal.get();
    }

    public static void init(String token, int uid, int role, Set<String> permission) {
        UserSession session = new UserSession();
        session.setToken(token);
        session.setUid(uid);
        session.setRole(role);
        session.setPermission(permission);
        threadLocal.set(session);
    }
}
