package ru.progwards.java1.lessons.abstractnum;

public class Ball extends Figure3D {

    public Ball(Number segment) {
        super(segment);
    }

    @Override
    public Number volume() {
        return segment.div(segment.mul(segment.mul(segment.mul(segment.mul(segment, segment), segment),
                segment.newNumber("3.1415926535")), segment.newNumber("4")), segment.newNumber("3"));
    }
}
