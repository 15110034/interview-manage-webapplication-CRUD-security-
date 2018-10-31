package com.group5.interviewmanage.commands;

import com.group5.interviewmanage.domain.Candidate;

import java.util.HashSet;
import java.util.Set;

public class SkillCommand {


        private Long id;
        private String name;
        private Set<Candidate> candidates = new HashSet<>();

        public SkillCommand() {
        }

        public SkillCommand(String name, Set<Candidate> candidates) {
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
