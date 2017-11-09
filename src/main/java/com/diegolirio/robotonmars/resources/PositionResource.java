package com.diegolirio.robotonmars.resources;

import com.diegolirio.robotonmars.command.Command;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.types.OrientationType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class PositionResource {

	@Setter
	private OrientationType orientation;
	private int x, y;
	private SizeResources size;

	public void addY(int add) throws InvalidPosition {
		y+=add;
		if(!isValidPositionY(y)) { 		
			throw new InvalidPosition("Posição Inválida");
		}
	}

	public void addX(int add) throws InvalidPosition {
		x+=add;
		if(!isValidPositionX(x)) { 		
			throw new InvalidPosition("Posição Inválida");
		}
	}

	private boolean isValidPositionY(int y) {
		return y >= 0 && y <= size.getY()-1;
	}
	
	private boolean isValidPositionX(int x) {
		return x >= 0 && x <= size.getX()-1;
	}

	public PositionResource initPosition() {
		this.y = 0;
		this.x = 0;
		this.orientation = OrientationType.NORTH;
		return this;
	}

	@JsonIgnore
	public Command getOrientationCommand() {
		return this.orientation.getCommand();
	}	
	
}
