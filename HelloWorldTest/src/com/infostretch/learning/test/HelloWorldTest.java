package com.infostretch.learning.test;

import android.test.ActivityInstrumentationTestCase2;

import com.infostretch.learning.MainActivity;
import com.jayway.android.robotium.solo.Solo;


public class HelloWorldTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	
	public HelloWorldTest() {
		super(MainActivity.class);
	}
	
	@Override
	public void setUp() throws Exception {
		//setUp() is run before a test case is started. 
		//This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	/*@Override
	public void tearDown() throws Exception {
		//tearDown() is run after a test case has finished. 
		//finishOpenedActivities() will finish all the activities that have been opened during the test execution.
		solo.finishOpenedActivities();
	}*/
	
	/**
	 * This method test the setting menu functionality is it working fine or not.
	 * @throws Exception
	 */
	public void testOpenSettingMenu() throws Exception{
		solo.clickOnMenuItem("Settings");
		//Assert that Setting activity is opened
		solo.assertCurrentActivity("Expected settingActivity", "SettingActivity");
		//Click on Button ..
		solo.clickOnButton("Button");
		// Enter the text
		solo.enterText(0, "Note 1");
		// Now go back to main screen.
		solo.goBack();
		// Take the screen shot
		solo.takeScreenshot();
	}
	
	/**
	 * Home Screen Button click is checked by this method.
	 * When button is clicked next activity is opened.
	 * @throws Exception
	 */
	public void testAddActivity() throws Exception{
		//Assert that Setting activity is opened
		solo.assertCurrentActivity("Expected MainActivity", "MainActivity");
		solo.clickOnButton("Open Next Activity");
		solo.enterText(0, "Next Activity is opened");
		solo.goBack();
	}
	
}
