package com.transperfect.services;

import com.transperfect.entities.Profile;

import java.util.List;

public interface IService {
    Profile saveProfile(Profile profile);

    Profile updateProfile(Profile profile, Long id);

    List<Profile> getAll();

}
