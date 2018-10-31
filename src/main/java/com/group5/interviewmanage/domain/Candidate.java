package com.group5.interviewmanage.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private java.sql.Date birthDay;
    private String email;
    private String phone;
    private String university;
    private String major;
    private double gpa;
    private String address;
    @ManyToOne
    private Position position;
    @OneToMany(mappedBy = "candidate")
    private Set<InterviewResult> interviewResults = new HashSet<>();
    @ManyToMany(mappedBy = "candidates")
    private Set<Skill> skills = new HashSet<>();

    public Candidate() {
    }

    public Candidate(String name, Date birthDay, String email, String phone, String university, String major, double gpa, String address, Position position, Set<InterviewResult> interviewResults, Set<Skill> skills) {
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.university = university;
        this.major = major;
        this.gpa = gpa;
        this.address = address;
        this.position = position;
        this.interviewResults = interviewResults;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<InterviewResult> getInterviewResults() {
        return interviewResults;
    }

    public void setInterviewResults(Set<InterviewResult> interviewResults) {
        this.interviewResults = interviewResults;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }


}
