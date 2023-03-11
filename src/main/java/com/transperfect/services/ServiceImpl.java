package com.transperfect.services;

import com.transperfect.entities.Profile;
import com.transperfect.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImpl implements IService {

    @Autowired
    private ProfileRepository profileRepository;

    /**
     * Save the profile
     *
     * @param profile
     * @return the saved profile
     */
    @Override
    @Transactional
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    /**
     * This method update the profile , it retrieves it first from the bdd and then update it
     *
     * @param profile
     * @param id
     * @return the updated profile
     */
    @Override
    @Transactional
    public Profile updateProfile(Profile profile, Long id) {

        Optional<Profile> optionalUserProfile = profileRepository.findById(id);

        if (!optionalUserProfile.isPresent()) throw new IllegalArgumentException("User not found");

        // update the user profile with the new data
        Profile userProfile = optionalUserProfile.get();
        userProfile.setName(profile.getName());
        userProfile.setEmail(profile.getEmail());
        userProfile.setPassword(profile.getPassword());
        userProfile.setEducations(profile.getEducations());
        userProfile.setWorkExperiences(profile.getWorkExperiences());
        // save the updated user profile to database
        return profileRepository.save(userProfile);
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }
}
