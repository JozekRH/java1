package ru.progwards.java1.lessons.interfaces2;

public class Duck extends Animal implements CompareWeight {

	public Duck(String name) {
		super(name);
	}

	public Duck(String name, double weight){
		super(name, weight);
	}

	@Override
	public String kind() {
		return "утка";
	}

	@Override
	public String say() {
		return "кря-кря";
	}

	@Override
	public FoodKind getFoodKind() {
		return FoodKind.CORN;
	}

	@Override
	public double getFoodCoeff() {
		return 0.04;
	}

	@Override
	public Color getColor() {
		return Color.GRAY;
	}

	@Override
	public String getHome() {
		return "ферма";
	}
}
