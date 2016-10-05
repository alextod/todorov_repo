package com.todorov.database;

import com.todorov.model.Message;
import com.todorov.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 04.10.2016.
 */
public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    static {
        Message m1 = new Message(1L, "New York", "Alex");
        Message m2 = new Message(2L, "Los Angeles", "Mark");
        messages.put(1L, m1);
        messages.put(2L, m2);

        Profile p1 = new Profile(1L, "jason", "Jason", "Statham");
        Profile p2 = new Profile(2L, "martin", "Martin", "Lawrence");
        profiles.put(p1.getProfileName(), p1);
        profiles.put(p2.getProfileName(), p2);
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
