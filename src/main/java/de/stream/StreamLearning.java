package de.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLearning {

	public List<String> playAround() {
		return Arrays.asList("b1", "a2", "b1", "c2", "c1").stream()
				.filter(item -> item.startsWith("a"))
				.collect(Collectors.toList());
	}

	public List<Character> streamAlphabet() {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				.chars()
				.mapToObj(character -> (char) character)
				.collect(Collectors.toList());
	}

	public List<String> addAToAlphabetTest() {
		return streamAlphabet()
				.stream()
				.map(character -> character.toString() + "A")
				.collect(Collectors.toList());
	}
}
