package ru.progwards.java1.lessons.params;

public class IntInteger extends AbsInteger {

	private int val;
	
	public IntInteger(int val){
		this.val = val;
	}
	
	@Override
	public int intValue(){
		return this.val;
	}
	
	@Override
	public String toString(){
		return Integer.toString(this.val);
	}
}
