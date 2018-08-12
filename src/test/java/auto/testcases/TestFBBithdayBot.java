package auto.testcases;

/*
 * Created by: Prerna Pal Email: prerna.chanchal13@gmail.com Date: 12-Aug-18
 */

import org.testng.annotations.Test;
import auto.pages.FBLoginPage;
import auto.utility.Init;

public class TestFBBithdayBot extends Init {

	@Test
	public void testNavigateToFriendsBirthday() {
		FBLoginPage fbLoginPage = new FBLoginPage(driver);
		fbLoginPage.verifyFBLoginPageHeader();
		fbLoginPage.loginToYourAccount("<username>", "<password>");
		fbLoginPage.navigateToFriendsBirthdaysToday();
		fbLoginPage.writeBirthdayWishes("Happy Birthday!!");
	}
}
