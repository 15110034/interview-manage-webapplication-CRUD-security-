package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.SkillCommand;
import com.group5.interviewmanage.domain.Skill;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SkillCommandSkill implements Converter<SkillCommand, Skill>{
    @Override
    public Skill convert(SkillCommand skillCommand) {
        if(skillCommand == null) return null;

        Skill skill = new Skill();
        skill.setId(skillCommand.getId());
        skill.setName(skillCommand.getName());
        skill.setCandidates(skillCommand.getCandidates());
        return skill;
    }
}
