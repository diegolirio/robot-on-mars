package com.diegolirio.robotonmars.services;

import com.diegolirio.robotonmars.exceptions.InvalidCommand;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;

public interface RobotCommandService  {

	PositionResource command(String command) throws InvalidCommand, InvalidPosition;

}
