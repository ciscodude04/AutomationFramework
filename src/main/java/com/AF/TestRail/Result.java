package com.AF.TestRail;

public class Result {
	
	private static final int Pass = 1;
	private static final int Blocked = 2;
	private static final int Untested = 3;
	private static final int Retest = 4;
	private static final int Failed = 5;
	
	public static int Pass(){
		return Pass;
	}
	
	public static int Blocked(){
		return Blocked;
	}
	
	public static int Untested(){
		return Untested;
	}
	
	public static int Retest(){
		return Retest;
	}
	
	public static int Failed(){
		return Failed;
	}
}
