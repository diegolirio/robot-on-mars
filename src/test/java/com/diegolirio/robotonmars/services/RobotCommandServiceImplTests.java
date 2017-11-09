package com.diegolirio.robotonmars.services;

import static com.diegolirio.robotonmars.types.OrientationType.SOUTH;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diegolirio.robotonmars.exceptions.InvalidCommand;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotCommandServiceImplTests {

	@Autowired
	private RobotCommandService robotCommandService;
	
	@Test(expected=InvalidPosition.class)
	public void testCommandtestCommandExpectedInvalidPosition() throws InvalidCommand, InvalidPosition {
		robotCommandService.command("MMMMMMMMMMMMMMMMMMMMMMMM");
	}	
	
	@Test(expected=InvalidCommand.class)
	public void testCommandtestCommandExpectedInvalidCommand() throws InvalidCommand, InvalidPosition {
		robotCommandService.command("AAA");
	}		
	
	@Test 
	public void testOfficialStart00NExecuteCommandMMRMMRMM() throws Exception {
		PositionResource position = robotCommandService.command("MMRMMRMM");
		assertEquals(2, position.getX());
		assertEquals(0, position.getY());
		assertEquals(SOUTH, position.getOrientation());
	}	
	
	
	
}
