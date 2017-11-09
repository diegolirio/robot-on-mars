package com.diegolirio.robotonmars.types;

import java.util.HashMap;
import java.util.Map;

import com.diegolirio.robotonmars.command.Command;
import com.diegolirio.robotonmars.command.CommandEast;
import com.diegolirio.robotonmars.command.CommandNoth;
import com.diegolirio.robotonmars.command.CommandSouth;
import com.diegolirio.robotonmars.command.CommandWest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

public enum OrientationType {

	NORTH('N') {
		@Override
		public Command getCommand() {
			return commandsFlyweight.get(NORTH);
		}
	},
	SOUTH('S') {
		@Override
		public Command getCommand() {
			return commandsFlyweight.get(SOUTH);
		}
	},
	EAST('E') {
		@Override
		public Command getCommand() {
			return commandsFlyweight.get(EAST);
		}
	},
	WEST('W') {
		@Override
		public Command getCommand() {
			return commandsFlyweight.get(WEST);
		}
	};
	
	@JsonIgnore
	private static Map<OrientationType, Command> commandsFlyweight = new HashMap<>();
	static {
		commandsFlyweight.put(NORTH, new CommandNoth());
		commandsFlyweight.put(SOUTH, new CommandSouth());
		commandsFlyweight.put(EAST, new CommandEast());
		commandsFlyweight.put(WEST, new CommandWest());
	}

	@Getter
	private char letter;
	
	private OrientationType(char letter) {
		this.letter = letter;
	}

	public abstract Command getCommand();
}
