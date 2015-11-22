/*
 * Copyright 2011 psiinon@gmail.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 *   http://www.apache.org/licenses/LICENSE-2.0
 */
package com.thebodgeitstore.selenium.tests;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FunctionalZAP extends FunctionalTest {

	public void setUp() throws Exception {
		String target = System.getProperty("zap.targetApp");
		if (target != null && target.length() > 0) {
			// Theres an override
			setSite(target);
		}

		Proxy proxy = new Proxy();
		proxy.setHttpProxy(System.getProperty("zap.proxy"));
		
		// We use firefox as an example here.
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(CapabilityType.PROXY, proxy);

		// You could use any webdriver implementation here
		WebDriver driver = new FirefoxDriver(capabilities);
		this.setDriver(driver);
	}

	public static void main(String[] args) throws Exception {
		FunctionalZAP test = new FunctionalZAP();
		test.setUp();
		test.testAll();
		test.tearDown();
		
	}


}
