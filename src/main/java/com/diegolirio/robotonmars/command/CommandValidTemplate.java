package com.diegolirio.robotonmars.command;

import com.diegolirio.robotonmars.exceptions.InvalidCommand;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;
import com.diegolirio.robotonmars.types.CommandType;

public abstract class CommandValidTemplate implements Command {

	private CommandType commandIsValid(char command) throws InvalidCommand {
		for (CommandType ct : CommandType.values()) {
			if(ct.getLetter() == command) return ct;
		}
		throw new InvalidCommand("Comando Invalido");
	}

	@Override
	public PositionResource execute(char cmd, PositionResource position) throws InvalidCommand, InvalidPosition {
		CommandType commandType = commandIsValid(cmd);
		return this.executeCommandValid(commandType, position);
	}

	protected abstract PositionResource executeCommandValid(CommandType cmd, PositionResource position) throws InvalidCommand, InvalidPosition;
	
}
