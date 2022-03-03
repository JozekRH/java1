package ru.progwards.java1.lessons.params;

public class ByteInteger extends AbsInteger {

	private byte val;
	
	public ByteInteger(byte val){
		this.val = val;
	}

	@Override
	public byte byteValue(){
		return this.val;
	}
	
	@Override
	public int intValue(){
		return this.val;
	}

	@Override
	public String toString(){
		return Byte.toString(this.val);
	}
}
