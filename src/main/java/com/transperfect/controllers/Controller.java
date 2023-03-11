package com.transperfect.controllers;

import com.transperfect.entities.Profile;
import com.transperfect.exceptions.IncorrectData;
import com.transperfect.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Controller {

    static final String SUCCESSFUL_CREAION = "User created successfully";

    @Autowired
    private ServiceImpl service;

    /**
     * Save the profile if valid , else throw exception that are handled in the advice controller
     *
     * @param profile
     * @param bindingResult
     * @return ResposneEntity
     * @throws IncorrectData
     */
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(
            @Valid @RequestBody Profile profile, BindingResult bindingResult) throws IncorrectData {
        if (bindingResult.hasErrors()) {
            throw new IncorrectData(bindingResult);
        }
        service.saveProfile(profile);
        return new ResponseEntity<>(SUCCESSFUL_CREAION, HttpStatus.CREATED);
    }

    /**
     * Update the profile if valid , else throw exception that are handled in the advice controller
     *
     * @param id
     * @param profile
     * @param bindingResult
     * @return r
     * @throws IncorrectData
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUserProfile(
            @PathVariable Long id, @Valid @RequestBody Profile profile, BindingResult bindingResult)
            throws IncorrectData {
        if (bindingResult.hasErrors()) {
            throw new IncorrectData(bindingResult);
        }
        return new ResponseEntity<>(service.updateProfile(profile, id), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.ACCEPTED);
    }
}
