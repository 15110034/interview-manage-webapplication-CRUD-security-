package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.SkillCommand;
import com.group5.interviewmanage.domain.Skill;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SkillSkillCommand implements Converter<Skill, SkillCommand> {
    @Override
    public SkillCommand convert(Skill skill) {
        if(skill == null)
            return null;

        final SkillCommand skillCommand = new SkillCommand();
        skillCommand.setId(skill.getId());
        skillCommand.setName(skill.getName());
        skillCommand.setCandidates(skill.getCandidates());
        return skillCommand;
    }
}
