package com.diegolirio.robotonmars.command;

import com.diegolirio.robotonmars.exceptions.InvalidCommand;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;

public interface Command {

	PositionResource execute(char command, PositionResource position) throws InvalidCommand, InvalidPosition;

}
