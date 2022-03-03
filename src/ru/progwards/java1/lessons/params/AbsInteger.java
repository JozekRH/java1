package ru.progwards.java1.lessons.params;

public abstract class AbsInteger{

    public static AbsInteger add(AbsInteger num1, AbsInteger num2)
    {
        int res = num1.intValue() + num2.intValue();
        if (res >= Byte.MIN_VALUE && 
                res <= Byte.MAX_VALUE) {
                return new ByteInteger((byte)res);
            } else if (res >= Short.MIN_VALUE &&
                    res <= Short.MAX_VALUE) {
                return new ShortInteger((short)res);
            }
        
        return new IntInteger(res);
    }

    public byte byteValue(){
        return 0;
    }
    
    public short shortValue(){
        return 0;
    }
    
    public int intValue(){
        return 0;
    }

    public String toString(){
        return null;
    }
}