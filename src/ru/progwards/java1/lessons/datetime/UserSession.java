package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.Random;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private int lastAccess;

    public int getSessionHandle() {
        return sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public int getLastAccess() {
        return lastAccess;
    }

    public void updateLastAccess() {
        lastAccess = (int)Instant.now().getEpochSecond();
    }

    public UserSession(String userName) {
        this.userName = userName;
        this.lastAccess = (int)Instant.now().getEpochSecond();
        Random random = new Random((int)Instant.now().getEpochSecond());
        this.sessionHandle = random.nextInt();
    }
}
