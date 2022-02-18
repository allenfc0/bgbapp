package com.bakerygb.bgbapp.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity(name = "jobs")
public class Job {

    @Id
    @SequenceGenerator(
            name = "job_sequence",
            sequenceName = "sequence_job",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_sequence"
    )
    Long id;
    String title;
    String description;
    Double pay;

    public Job(String title, String description, Double pay) {
        this.title = title;
        this.description = description;
        this.pay = pay;
    }

}
