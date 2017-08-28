package com.czecht.architecture.solid.isp.good;

/**
 * Created by czecht on 2017-05-29.
 */
public interface Workable {
	void work();
}

interface Feedable {
	void feed();
}

class Worker implements Workable, Feedable {

	@Override
	public void feed() {

	}

	@Override
	public void work() {

	}
}

class Robot implements Workable {

	@Override
	public void work() {

	}
}
