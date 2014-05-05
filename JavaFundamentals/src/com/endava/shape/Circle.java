package com.endava.shape;

public class Circle extends Shape{
	private int radius;
	
	public Circle(int radius) {
		this.radius=radius;
	}
	
	public void setRadius(int radius) {
		this.radius=radius;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public double computeArea() {
		return 3.14*radius*radius;
	}
	
	@Override
	public void helloWorld() {
		super.helloWorld();
		System.out.println("Hello World from Circle");
	}
}
