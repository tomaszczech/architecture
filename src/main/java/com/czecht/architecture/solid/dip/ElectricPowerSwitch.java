package com.czecht.architecture.solid.dip;

/**
 * Created by czecht on 2017-05-30.
 */
public class ElectricPowerSwitch {
	public Switchable client;
	public boolean on;
	public ElectricPowerSwitch(Switchable client) {
		this.client = client;
		this.on = false;
	}
	public boolean isOn() {
		return this.on;
	}
	public void press(){
		boolean checkOn = isOn();
		if (checkOn) {
			client.turnOff();
			this.on = false;
		} else {
			client.turnOn();
			this.on = true;
		}

	}
}
