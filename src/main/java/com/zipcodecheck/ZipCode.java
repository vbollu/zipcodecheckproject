package com.zipcodecheck;

public class ZipCode{
	Integer startZipCode;
	Integer endZipCode;
	public Integer getStartZipCode() {
		return startZipCode;
	}
	public void setStartZipCode(Integer startZipCode) {
		this.startZipCode = startZipCode;
	}
	public Integer getEndZipCode() {
		return endZipCode;
	}
	public void setEndZipCode(Integer endZipCode) {
		this.endZipCode = endZipCode;
	}
	
	@Override
	public String toString() {
		return "["+startZipCode+","+endZipCode+"]";
	}
	
}