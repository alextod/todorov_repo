package com.todorov.service;

import com.todorov.database.DatabaseClass;
import com.todorov.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 04.10.2016.
 */
public class ProfileService {
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public List<Profile> getAllProfiles(){
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    public void removeProfile(String profileName){
        profiles.remove(profileName);
    }
}
