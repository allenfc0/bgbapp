package com.bakerygb.bgbapp.database;

/*
@author(Allen Farias)
@version(12-18-21)
description: this class will push user data into the database - bgbapp table user
 */

import com.bakerygb.bgbapp.dao.JobRepository;
import com.bakerygb.bgbapp.dao.UserRepository;
import com.bakerygb.bgbapp.models.Job;
import com.bakerygb.bgbapp.models.User;
import com.bakerygb.bgbapp.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InsertDataConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository){
        return args -> {
            User user1 = new User(

                    "Allen",
                "allenfc",
                "allen@email.com",
                    BCrypt.hashpw("abcd", BCrypt.gensalt(10)),
                    "ADMIN"
            );

            User user2 = new User(

                    "Itzia",
                    "itziafc",
                    "itzia@email.com",
                    BCrypt.hashpw("1234", BCrypt.gensalt(10)),
                    "CUSTOMER"
            );

            List<User> usersList = new ArrayList<>();
            usersList.add(user1);
            usersList.add(user2);

            userRepository.saveAll(usersList);
        };
    }

    @Bean
    CommandLineRunner jobCommandLineRunner(JobRepository jobRepository) {
        return args -> {
            Job job1 = new Job(
                    "Dough Master",
                    "Making that dough iykyk",
                    15D
            );

            Job job2 = new Job(
                    "Assistant Manager",
                    "Sub-Manager",
                    20D
            );

            List<Job> jobsList = new ArrayList<>();
            jobsList.add(job1);
            jobsList.add(job2);

            jobRepository.saveAll(jobsList);
        };
    }
}
