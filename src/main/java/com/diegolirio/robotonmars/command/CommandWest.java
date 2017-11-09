package com.diegolirio.robotonmars.command;

import org.springframework.stereotype.Component;

import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;
import com.diegolirio.robotonmars.types.CommandType;
import com.diegolirio.robotonmars.types.OrientationType;

@Component("commandWest")
public final class CommandWest extends CommandValidTemplate {

	@Override
	protected PositionResource executeCommandValid(CommandType cmd, PositionResource position) throws InvalidPosition {
		if(cmd == CommandType.MOVE) {
			position.addX(-1); 
		}
		if(cmd == CommandType.ROTATION_LEFT_90) { 
			position.setOrientation(OrientationType.SOUTH); 
		}
		if(cmd == CommandType.ROTATION_RIGHT_90) { 
			position.setOrientation(OrientationType.NORTH);
		}
		return position;
	}

}
