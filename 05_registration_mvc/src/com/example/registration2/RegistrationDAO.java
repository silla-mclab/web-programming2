package com.example.registration2;

import java.util.HashMap;
import java.util.Map;

public class RegistrationDAO {
	private Map<String, PersonalInfoDO> registrationDB = new HashMap<String, PersonalInfoDO>();
	
	public boolean registerPersonalInfo(PersonalInfoDO pi) {
		registrationDB.put(pi.getId(), pi);
		return true;
	}
	
	public PersonalInfoDO getPersonalInfo(String id) {
		PersonalInfoDO pi = registrationDB.get(id);
		return pi;
	}
	
}
