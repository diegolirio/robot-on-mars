package com.diegolirio.robotonmars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.robotonmars.command.Command;
import com.diegolirio.robotonmars.exceptions.InvalidCommand;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;
import com.diegolirio.robotonmars.services.settings.RobotSettings;

@Service
public class RobotCommandServiceImpl implements RobotCommandService {
	
	@Autowired
	private RobotSettings robotSettings;

	@Override
	public PositionResource command(String commands) throws InvalidCommand, InvalidPosition {
		PositionResource position = this.robotSettings.createPositionInitialSettings();
		position = executeCommand(commands, position);
		return position;
	}	

	private PositionResource executeCommand(String commandsString, PositionResource position) throws InvalidCommand, InvalidPosition {
		for(char cmd : commandsString.toCharArray()) {
			Command command = position.getOrientationCommand(); 
			position = command.execute(cmd, position);
		}
		return position;
	}

}
