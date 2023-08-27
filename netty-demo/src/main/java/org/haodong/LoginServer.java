package org.haodong;

import java.util.HashMap;
import java.util.Map;

public class LoginServer {
    private static Map<String, String> userDB = new HashMap<>();
    static {
        userDB.put("john","123");
        userDB.put("tom","234");
        userDB.put("alice","345");
    }
    public static String login(String username, String password) {
        if (password.equals(userDB.get(username))) {
            return username;
        } else {
            return null;
        }
    }
}
