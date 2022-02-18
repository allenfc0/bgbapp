package com.bakerygb.bgbapp.services;

import com.bakerygb.bgbapp.dao.JobRepository;
import com.bakerygb.bgbapp.models.Job;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void addJob(Job newJob) {
        jobRepository.save(newJob);
        log.warn("new Job added to the database");
    }

    public void deleteJobById(Long id) {
        log.warn("Job deleted from the database");
        jobRepository.deleteById(id);
    }

    public List<Job> getAllJobs() {
        List<Job> allJobs = jobRepository.findAll();
        log.warn("All Jobs listed " + allJobs.toString());
        return allJobs;
    }

    public Job getJobById(Long id) {
        Job foundJob = jobRepository.getById(id);
        log.warn("Id: " + id + "\nFound Job: " + foundJob);
        return foundJob;
    }
}
