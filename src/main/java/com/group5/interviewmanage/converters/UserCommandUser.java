package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.UserCommand;
import com.group5.interviewmanage.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserCommandUser implements Converter<UserCommand, User>{
    @Override
    public User convert(UserCommand userCommand) {
        if(userCommand == null) return null;
        User user = new User();
        user.setId(userCommand.getId());
        user.setAccountFsoft(userCommand.getAccountFsoft());
        user.setPassword(userCommand.getPassword());
        user.setRoles(userCommand.getRoles());

        return user;
    }
}
