package com.czecht.architecture.solid.dip;

/**
 * Created by czecht on 2017-05-30.
 */
public class Fan implements Switchable {
	@Override
	public void turnOn() {
		System.out.println("Fan: Fan turned on...");
	}

	@Override
	public void turnOff() {
		System.out.println("Fan: Fan turned off...");
	}
}
