package by.tc.opinionpull.controller;

import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.controller.command.CommandName;
import by.tc.opinionpull.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandName.LOGIN, new LogIn());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.SIGNIN, new SignUp());
        repository.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguage());
        repository.put(CommandName.LOGOUT, new LogOut());
        repository.put(CommandName.LOAD_CONTENT, new LoadContent());
        repository.put(CommandName.PASS_POLL, new PassPoll());
        repository.put(CommandName.COMPLETE_POLL, new CompletePoll());
        repository.put(CommandName.USER_SETTINGS, new UserSettings());

        repository.put(CommandName.EDIT, new Edit());
        repository.put(CommandName.DELETE_POLL, new DeletePoll());
        repository.put(CommandName.EDIT_POLL, new EditPoll());
        repository.put(CommandName.ADD_POLL, new AddPoll());

        repository.put(CommandName.DELETE_ANSWER, new DeleteAnswer());
        repository.put(CommandName.EDIT_ANSWER, new EditAnswer());
        repository.put(CommandName.ADD_ANSWER, new AddAnswer());

        repository.put(CommandName.DELETE_POLL, new DeletePoll());
        repository.put(CommandName.EDIT_QUESTION, new EditQuestion());
        repository.put(CommandName.ADD_QUESTION, new AddQuestion());

        repository.put(CommandName.CHECK_ADMIN_USER, new CheckBecomeAdmin());
    }

    Command getCommand(String name){


        CommandName commandName =null;
        Command command = null;

        try{
	        commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){
            LOGGER.error(e);
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
