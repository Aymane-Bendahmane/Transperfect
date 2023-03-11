package com.transperfect.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transperfect.controllers.Controller;
import com.transperfect.entities.Education;
import com.transperfect.entities.Profile;
import com.transperfect.entities.WorkExperience;
import com.transperfect.repositories.ProfileRepository;
import com.transperfect.services.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
public class ControllerTest {

    @Mock
    private ProfileRepository profileRepository;

    @MockBean
    private ServiceImpl service;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testCreateUserProfile() throws Exception {
        Profile profile = new Profile();
        profile.setName("John Doe");
        profile.setEmail("john.doe@example.com");
        profile.setPassword("password123Az$*");
        profile.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));
        String requestJson = new ObjectMapper().writeValueAsString(profile);
        when(service.saveProfile(profile)).thenReturn(profile);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateUserProfile() throws Exception {
        Profile profile = new Profile();
        profile.setName("John Doe");
        profile.setEmail("john.doe@example.com");
        profile.setPassword("newPassword123*/");
        profile.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));

        when(profileRepository.findById(1L)).thenReturn(Optional.of(profile));

        Profile profile2 = new Profile();
        profile2.setName("John Doe");
        profile2.setEmail("john.doe@example.com");
        profile2.setPassword("newPassword123*/");
        profile2.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile2.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));
        String requestJson = new ObjectMapper().writeValueAsString(profile2);

        mockMvc
                .perform(MockMvcRequestBuilders.put("/update/1").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testIncorrectPasswordNoSpecialCharacter() throws Exception {
        Profile profile = new Profile();
        profile.setName("John Doe");
        profile.setEmail("john.doe@example.com");
        profile.setPassword("password123Az");
        profile.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));
        String requestJson = new ObjectMapper().writeValueAsString(profile);
        when(service.saveProfile(profile)).thenReturn(profile);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0]").value("Password must contain at least one special character"));
    }

    @Test
    public void testIncorrectPasswordLessThen8Character() throws Exception {
        Profile profile = new Profile();
        profile.setName("John Doe");
        profile.setEmail("john.doe@example.com");
        profile.setPassword("p*A12");
        profile.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));
        String requestJson = new ObjectMapper().writeValueAsString(profile);
        when(service.saveProfile(profile)).thenReturn(profile);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0]").value("Password must be between 8 and 20 characters"));
    }


    @Test
    public void testRequiredName() throws Exception {
        Profile profile = new Profile();
        profile.setName(null);
        profile.setEmail("john.doe@example.com");
        profile.setPassword("pass1234AZ$*");
        profile.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));
        String requestJson = new ObjectMapper().writeValueAsString(profile);
        when(service.saveProfile(profile)).thenReturn(profile);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0]").value("Name is required"));
    }

    @Test
    public void testRequiredEmail() throws Exception {
        Profile profile = new Profile();
        profile.setName("test");
        profile.setEmail(null);
        profile.setPassword("pass1234AZ$");
        profile.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));
        String requestJson = new ObjectMapper().writeValueAsString(profile);
        when(service.saveProfile(profile)).thenReturn(profile);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0]").value("Email is required"));
    }

    @Test
    public void testInvalidEmail() throws Exception {
        Profile profile = new Profile();
        profile.setName("test");
        profile.setEmail("john.doeexample.com");
        profile.setPassword("pass1234AZ$");
        profile.setEducations(
                Arrays.asList(
                        new Education("Developement web et genie logiciel at ISGA"),
                        new Education("Miage ASCI at Lorraine university")));
        profile.setWorkExperiences(
                Arrays.asList(
                        new WorkExperience(
                                "ingenieur d'etude et developement informatique at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"),
                                null,
                                true),
                        new WorkExperience(
                                "Stage pre-embouche at ADRIA B&T",
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-10"),
                                new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-31"),
                                false)));
        String requestJson = new ObjectMapper().writeValueAsString(profile);
        when(service.saveProfile(profile)).thenReturn(profile);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0]").value("Invalid email format"));
    }

    @Test
    public void testEducationAndWorkExperienceNotRequired() throws Exception {
        Profile profile = new Profile();
        profile.setName("test");
        profile.setEmail("john.doe@example.com");
        profile.setPassword("pass1234AZ$");

        String requestJson = new ObjectMapper().writeValueAsString(profile);
        when(service.saveProfile(profile)).thenReturn(profile);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isCreated());
    }

}
