package com.mjc.school.util;

public enum TalkingAt {
	//
	Left(0), 
	Middle(3), 
	Right(6);
	
	private final int tabCount;
	
	private TalkingAt(int tabCount) {
		this.tabCount = tabCount; 
	}
	
	public int tabCount() {
		return tabCount;
	}
}