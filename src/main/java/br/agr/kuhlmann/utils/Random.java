package br.agr.kuhlmann.utils;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Random {
	
	public void random() {
	
		int random = (int) (Math.random() * 10000);
		Set<Integer> numeros = new TreeSet<Integer>();
		Random rand = new Random();
		while (numeros.size() < 1) {
			numeros.add(rand.nextInt(10000));
		}
	}

}
