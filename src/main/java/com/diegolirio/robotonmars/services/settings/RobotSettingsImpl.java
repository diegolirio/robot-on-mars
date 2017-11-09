package com.diegolirio.robotonmars.services.settings;

import org.springframework.stereotype.Component;

import com.diegolirio.robotonmars.resources.PositionResource;
import com.diegolirio.robotonmars.resources.SizeResources;

@Component
public class RobotSettingsImpl implements RobotSettings {

	@Override
	public PositionResource createPositionInitialSettings() {
		return PositionResource.builder().size(SizeResources.builder().x(5).y(5).build()).build().initPosition();
	}

}
