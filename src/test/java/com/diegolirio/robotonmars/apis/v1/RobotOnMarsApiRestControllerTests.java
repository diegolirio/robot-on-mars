package com.diegolirio.robotonmars.apis.v1;

import static com.diegolirio.robotonmars.types.OrientationType.NORTH;
import static com.diegolirio.robotonmars.types.OrientationType.SOUTH;
import static com.diegolirio.robotonmars.types.OrientationType.WEST;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.diegolirio.robotonmars.resources.PositionResource;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RobotOnMarsApiRestControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test 
	public void testOfficialStart00NExecuteCommandMML() throws Exception {
		PositionResource position = postRobotCommand("MML");
		assertEquals(0, position.getX());
		assertEquals(2, position.getY());
		assertEquals(WEST, position.getOrientation());
	}		
	
	@Test 
	public void testOfficialStart00NExecuteCommandMMRMMRMM() throws Exception {
		PositionResource position = postRobotCommand("MMRMMRMM");
		assertEquals(2, position.getX());
		assertEquals(0, position.getY());
		assertEquals(SOUTH, position.getOrientation());
	}
	
	@Test 
	public void testOfficialStart00NExecuteCommandAAA() throws Exception {
		postRobotCommandInvalid("AAA");
	}
	
	@Test 
	public void testOfficialStart00NExecuteCommandPositionInvalidMMMMMMMMMMMMMMMMMMMMMMMM() throws Exception {
		postRobotCommandPositionInvalid("MMMMMMMMMMMMMMMMMMMMMMMM");
	}
	
	@Test 
	public void testAnyStart00NExecuteCommandPositionInvalidLM() throws Exception {
		postRobotCommandPositionInvalid("LM");
	}		
	
	@Test 
	public void testAnyStart00NExecutePositionInvalidCommandRRM() throws Exception {
		postRobotCommandPositionInvalid("RRM");
	}		
	
	@Test 
	public void testAnyStart00NExecuteCommandM() throws Exception {
		PositionResource position = postRobotCommand("M");
		assertEquals(0, position.getX());
		assertEquals(1, position.getY());
		assertEquals(NORTH, position.getOrientation());
	}
	
	@Test 
	public void testAnyStart00NExecuteCommandMM() throws Exception {
		PositionResource position = postRobotCommand("MM");
		assertEquals(0, position.getX());
		assertEquals(2, position.getY());
		assertEquals(NORTH, position.getOrientation());
	}	
	
	
	@Test 
	public void testAnyStart00NExecuteAnyCommandMMLRAM() throws Exception {
		postRobotCommandInvalid("MMLRAM");
	}			
	
	@Test 
	public void testAnyStart00NExecuteCommandMMMMRMMRMMLMRMR() throws Exception {
		PositionResource position = postRobotCommand("MMMMRMMRMMLMRMR");
		assertEquals(3, position.getX());
		assertEquals(1, position.getY());
		assertEquals(WEST, position.getOrientation());
	}		
	 
	
	@Test 
	public void testAnyStart00NExecuteCommandMRML() throws Exception {
		PositionResource position = postRobotCommand("MRML");
		assertEquals(1, position.getX());
		assertEquals(1, position.getY());
		assertEquals(NORTH, position.getOrientation());
	}		
	
	@Test 
	public void testAnyStart00NExecuteCommandRMMMMLMMLMLMRMR() throws Exception {
		PositionResource position = postRobotCommand("RMMMMLMMLMLMRMR");
		assertEquals(2, position.getX()); 
		assertEquals(1, position.getY());
		assertEquals(NORTH, position.getOrientation());
	}
	
	private PositionResource postRobotCommand(String command) throws UnsupportedEncodingException, Exception {
		String jsonPosition = mockMvc.perform(post(RobotOnMarsApiRestController.URL+"/"+command)
												.accept(MediaType.APPLICATION_JSON_UTF8))
											.andExpect(status().isOk())
											.andReturn().getResponse().getContentAsString(); 
		return objectMapper.readValue(jsonPosition, PositionResource.class);
	}
	
	private void postRobotCommandPositionInvalid(String commandInvalid) throws UnsupportedEncodingException, Exception {
		String contentAsString = mockMvc.perform(post(RobotOnMarsApiRestController.URL+"/"+commandInvalid)
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isBadRequest())
						.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}
	
	private void postRobotCommandInvalid(String command) throws Exception {
		mockMvc.perform(post(RobotOnMarsApiRestController.URL+"/"+command)
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isBadRequest());
	}		
}


