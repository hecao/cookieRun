package com.hecao.cookie;

public class Tree {
	
	int frameCount;

	int width;
	int height;
	
	String name;
	float duration;
	
	public Tree(String name, int width, int height, int frameCount, float duration) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.frameCount = frameCount;
		this.duration = duration;
	}

}
