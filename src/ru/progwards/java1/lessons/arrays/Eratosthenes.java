package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int N) {
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        sift();
    }

    private void sift() {
        for(int i = 2; i < sieve.length; i++) {
            if(sieve[i]) {
                for(int j = i + 1; j < sieve.length; j++) {
                    if(j % i == 0) {
                        sieve[j] = false;
                    }
                }
            }

        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
    }
}
