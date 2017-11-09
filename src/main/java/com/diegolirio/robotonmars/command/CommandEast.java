package com.diegolirio.robotonmars.command;

import org.springframework.stereotype.Component;

import com.diegolirio.robotonmars.exceptions.InvalidCommand;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;
import com.diegolirio.robotonmars.types.CommandType;
import com.diegolirio.robotonmars.types.OrientationType;

@Component("commandEast")
public final class CommandEast extends CommandValidTemplate {

	@Override
	protected PositionResource executeCommandValid(CommandType cmd, PositionResource position) throws InvalidCommand, InvalidPosition {
		if(cmd == CommandType.MOVE) {
			position.addX(+1); 
		}
		if(cmd == CommandType.ROTATION_LEFT_90) { 
			position.setOrientation(OrientationType.NORTH);
		}
		if(cmd == CommandType.ROTATION_RIGHT_90) { 
			position.setOrientation(OrientationType.SOUTH);
		}
		return position;
	}


}
