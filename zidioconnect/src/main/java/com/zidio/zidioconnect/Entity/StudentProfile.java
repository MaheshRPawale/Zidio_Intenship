package com.zidio.zidioconnect.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentProfile {

// HELLO STUDENT 
    @Id
    private Long studentId;

    @OneToOne
    @MapsId  //typically used in one-to-one relationships with shared primary keys.
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String university;

    @Column(nullable = false)
    private String degree;

    @Column(name = "year_of_study", nullable = false)
    private int yearOfStudy;

    @Column(name = "resume_url")
    private String resumeUrl;
}
