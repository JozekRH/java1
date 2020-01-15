package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.*;

public class SessionManager {
    private Map<Integer, UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
        this.sessions = new HashMap<>();
    }

    public void add(UserSession userSession) {
        sessions.putIfAbsent(userSession.getSessionHandle(), userSession);
    }

    public UserSession find(String userName) {
        Collection<UserSession> userSessionsCollection = sessions.values();
        for (UserSession userSession : userSessionsCollection) {
            if (userName.equals(userSession.getUserName())) {
                if ((userSession.getLastAccess() + sessionValid*1000) <= Instant.now().toEpochMilli()) {
                    return null;
                } else {
                    userSession.updateLastAccess();
                    return userSession;
                }
            }
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        if (!sessions.containsKey(sessionHandle))
            return null;
        UserSession userSession = sessions.get(sessionHandle);
        if ((userSession.getLastAccess() + sessionValid*1000) <= Instant.now().toEpochMilli())
            return null;
        userSession.updateLastAccess();
        return userSession;
    }

    public void delete(int sessionHandle) {
        sessions.remove(sessionHandle);
    }

    public void deleteExpired() {
        Collection<UserSession> sessionsCollection = sessions.values();
        UserSession[] userSessionsArr = new UserSession[sessionsCollection.size()];
        userSessionsArr = sessionsCollection.toArray(userSessionsArr);
        for(int i = 0; i < userSessionsArr.length; i++) {
            if ((userSessionsArr[i].getLastAccess() + sessionValid*1000) <= Instant.now().toEpochMilli()) {
                delete(userSessionsArr[i].getSessionHandle());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SessionManager sessionManager = new SessionManager(2);
        System.out.println(sessionManager.find("User1"));
        UserSession userSession = new UserSession("User1");
        int handle = userSession.getSessionHandle();
        sessionManager.add(userSession);
        System.out.println(sessionManager.get(handle).getLastAccess());
        Thread.sleep(1000);
        System.out.println(sessionManager.get(handle).getLastAccess());
        Thread.sleep(1000);
        System.out.println(sessionManager.get(handle).getLastAccess());
        System.out.println(userSession.getLastAccess());
        Thread.sleep(2000);
        System.out.println(sessionManager.get(handle));
        System.out.println(sessionManager.sessions.size());
        sessionManager.deleteExpired();
        System.out.println(sessionManager.sessions.size());
    }
}
