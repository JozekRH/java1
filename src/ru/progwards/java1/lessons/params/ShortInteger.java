package ru.progwards.java1.lessons.params;

public class ShortInteger extends AbsInteger {

	private short val;
	
	public ShortInteger(short val){
		this.val = val;
	}

	@Override
	public short shortValue(){
		return this.val;
	}

	@Override
	public int intValue(){
		return this.val;
	}
	
	@Override
	public String toString(){
		return Short.toString(this.val);
	}
}
