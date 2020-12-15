package com.hillel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserParser {

    private final String regex = "(?:(\\w+):)?(?:((?<!@)\\b\\w+\\b(?!:)))(?:@(\\w+))?";

    public User parse(String user) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user);
        if (matcher.find()) {
            String nickname = matcher.group(1);
            String username = matcher.group(2);
            String password = matcher.group(3);
            if (nickname == null) {
                nickname = username;
            }
            return new User(nickname, username, password);
        }
        return null;
    }

    public List<User> parseText(String userText) {
        String[] users = userText.split(",");
        List<User> usersList = new ArrayList<>();
        for (String userStr : users) {
            User user = parse(userStr);
            if (user != null) {
                usersList.add(user);
            }
        }
        return usersList;
    }

    public List<String> getInvalidUsers(String userText) {
        String[] users = userText.split(",");
        List<String> invalidUsersList = new ArrayList<>();
        for (String userStr : users) {
            User user = parse(userStr);
            if (user == null) {
                invalidUsersList.add(userStr);
            }
        }
        return invalidUsersList;
    }
}

