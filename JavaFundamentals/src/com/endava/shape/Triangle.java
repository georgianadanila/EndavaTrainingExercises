package com.endava.shape;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class Triangle extends Shape {
	private int base;
	private int height;
	
	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public double computeArea() {
		return base*height/2;
	}
	
	@Override
	public void helloWorld() {
		super.helloWorld();
		System.out.println("Hello World from Circle");
	}
	
}
