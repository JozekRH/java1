package ru.progwards.java1.lessons.arrays2;

import java.util.Arrays;

public class IntArrays {

	public static String toString(int[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuilder b = new StringBuilder();
		b.append('[');
		for (int i = 0; ; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static boolean equals1(int[] a1, int[] a2){
		Arrays.sort(a1);
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}

	public static boolean equals2(int[] a1, int[] a2){
		return equals1(a1, a2);
	}
}
