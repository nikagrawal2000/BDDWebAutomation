package utils;

import pages.Login;

public class PageObjects {
	private static PageObjects pageobject;
	Login login;

	private PageObjects() {
	}

	public static PageObjects getInstance() {
		if(pageobject==null) {
			pageobject = new PageObjects();
		}
		return pageobject;
	}

	public Login login() {
		login = new Login();
		return login;
	}

}
