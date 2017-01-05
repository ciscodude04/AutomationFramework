package com.AF.webBridge;

import com.AF.webappCommandFlow.webappCommand;

public class WebAppBridge {
	
	public static webappCommand loginwith(String email){
		return new webappCommand(email);
	}

}
