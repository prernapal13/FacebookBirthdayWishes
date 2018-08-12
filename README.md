# FacebookBirthdayWishes
This project posts generic birthday wishes to facebook friend(s) having birthday.

# Description
A facebook utility, implemented using Java, Selenium Webdriver and TestNG. Page Object Model (POM) is used to make the code more readable, maintainable, and reusable. This utility can be downloaded and executed to post generic birthday wishes on your facebook friend(s) wall having birthday on the day.

# Pre-Requisite
1. Please provide your facebook user name and password as parameters in 'loginToYourAccount' method in TestFBBithdayBot.java file.
2. If you wish to change the generic message being posted, please edit the message being passed to 'writeBirthdayWishes' method in 'TestFBBithdayBot.java' file. At present the birthday wish that will be posted is 'Happy Birthday!!'.

# Possible Flows
1. Opens 'Firefox' in private mode > Navigates to 'http://www.facebook.com/' > Login to the account provided > Checks if there are any birthday notifications on the day > If one or more friends have birthday, goes to the notification for birthday > Posts the birthday wish on friend's wall > Logs out of facebook.
2. Opens 'Firefox' in private mode > Navigates to 'http://www.facebook.com/' > Login to the account provided > Checks if there are any birthday notifications on the day > If there are no birthday notifications, print 'None of the friends have their birthday today' > Logs out of facebook.
