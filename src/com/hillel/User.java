package com.hillel;

public class User {
    private final String nickname;
    private final String username;
    private final String password;

    public User(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User(" +
                "nickname = " + nickname +
                ", username = " + username +
                ", password = " + password + ")";
    }
}
