package org.gdas.bigreportsapi;

import org.gdas.bigreportsapi.controller.MockController;

import static org.gdas.bigreportsapi.config.APIProperties.getProperty;
import static spark.Spark.port;

public class BigReportsDataMakerApplication {

	public static void main(String[] args) {
		port(Integer.parseInt(getProperty("server.port")));
		new MockController();
	}

}
