package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.logging.SimpleFormatter;

public interface SkillRepository extends CrudRepository<Skill, Long> {
}
