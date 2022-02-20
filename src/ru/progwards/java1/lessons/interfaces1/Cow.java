package ru.progwards.java1.lessons.interfaces1;

public class Cow extends Animal{

	public Cow(String name) {
		super(name);
	}

	public Cow(String name, double weight) {
		super(name, weight);
	}

	@Override
	public String kind() {
		return "корова";
	}

	@Override
	public String say() {
		return "мууууууу";
	}

	@Override
	public FoodKind getFoodKind() {
		return FoodKind.HAY;
	}

	@Override
	public double getFoodCoeff() {
		return 0.05;
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}
}
