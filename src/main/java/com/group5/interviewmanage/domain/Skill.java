package com.group5.interviewmanage.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "candidate_skill",
            joinColumns = @JoinColumn(name = "skill_id"), inverseJoinColumns = @JoinColumn(name = "cadidate_id"))
    private Set<Candidate> candidates = new HashSet<>();

    public Skill() {
    }

    public Skill(String name, Set<Candidate> candidates) {
        this.name = name;
        this.candidates = candidates;
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

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }
}
