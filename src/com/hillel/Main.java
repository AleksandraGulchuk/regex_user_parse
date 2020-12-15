package com.hillel;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String text = "programmer:vasia@123, programmer:vasia, vasia@1234, vasia, vasia:@trulala, @1234";
        UserParser userParser = new UserParser();
        List<User> users = userParser.parseText(text);
        List<String> invalidUsers = userParser.getInvalidUsers(text);
        for (User user : users) {
            System.out.println(user);
        }
        for (String user : invalidUsers) {
            System.out.println(user + " - невалидный пользователь");
        }
    }
}
