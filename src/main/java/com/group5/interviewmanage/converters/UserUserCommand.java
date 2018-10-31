package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.UserCommand;
import com.group5.interviewmanage.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserUserCommand implements Converter<User, UserCommand> {
    @Override
    public UserCommand convert(User user) {
        if(user == null) return null;
        UserCommand userCommand = new UserCommand();
        userCommand.setId(user.getId());
        userCommand.setAccountFsoft(user.getAccountFsoft());
        userCommand.setPassword(user.getPassword());
        userCommand.setRoles(user.getRoles());

        return userCommand;
    }
}
