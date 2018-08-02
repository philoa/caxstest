package com.caxs.base.domain;

import java.io.Serializable;

public class UsrRole implements Serializable {
	
    private int id;
    
    private String usrLev;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getusrLev() {
		return usrLev;
	}

	public void setusrLev(String usrLev) {
		this.usrLev = usrLev;
	}
   
}
