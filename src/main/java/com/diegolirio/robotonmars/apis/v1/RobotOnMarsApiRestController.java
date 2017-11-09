package com.diegolirio.robotonmars.apis.v1;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.robotonmars.exceptions.InvalidCommand;
import com.diegolirio.robotonmars.exceptions.InvalidPosition;
import com.diegolirio.robotonmars.resources.PositionResource;
import com.diegolirio.robotonmars.services.RobotCommandService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(RobotOnMarsApiRestController.URL)
@Api(value="RobotOnMarsApi")
public class RobotOnMarsApiRestController {

	public static final String URL = "/rest/mars";
	
	@Autowired
	private RobotCommandService robotService;
			
	@PostMapping("/{command}")
	public ResponseEntity<PositionResource> postCommand(@PathVariable("command") String command) throws InvalidCommand, InvalidPosition {
		PositionResource position = this.robotService.command(command);
		return new ResponseEntity<PositionResource>(position, HttpStatus.OK);
	}

    @ExceptionHandler(InvalidCommand.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public String handle400InvalidCommand(Exception ex, Locale locale) {
    	return "{\"message\":\""+ex.getMessage() + "\"}";
    } 	

    @ExceptionHandler(InvalidPosition.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public String handle400InvalidPosition(Exception ex, Locale locale) {
    	return "{\"message\":\""+ex.getMessage() + "\"}";
    } 	    
}
