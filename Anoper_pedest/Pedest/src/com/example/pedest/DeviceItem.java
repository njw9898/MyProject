package com.example.pedest;

public class DeviceItem {
	private String MAC;
	private String DeviceName;
	
	public DeviceItem() {
		this.MAC = "";
		this.DeviceName="";
	}
	
	public DeviceItem(String newMAC, String newName) {
		this.MAC = newMAC;
		this.DeviceName = newName;
	}
	
	public String getMAC() {
		return this.MAC;
	}
	
	public String getDeviceName() {
		return this.DeviceName;
	}
	
	public void setMAC(String newMAC) {
		this.MAC = newMAC;
	}
	
	public void setDeviceName(String newName) {
		this.DeviceName = newName;
	}
}
