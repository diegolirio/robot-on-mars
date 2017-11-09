package com.diegolirio.robotonmars.types;

import lombok.Getter;

public enum CommandType {

	MOVE('M'), ROTATION_LEFT_90('L'), ROTATION_RIGHT_90('R');

	@Getter
	private char letter;

	CommandType(char letter) {
		this.letter = letter;
	}

}
