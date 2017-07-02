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

	public List<ShoePair> filterHighheels38() {
		List<ShoePair> shoePairs = Arrays.asList(
				new ShoePair("black", 38, true),
				new ShoePair("red", 39, true),
				new ShoePair("black", 38, false),
				new ShoePair("red", 38, true),
				new ShoePair("white", 39, false));
		return shoePairs
				.stream()
				.filter(item -> item.getSize() == 38 && item.isHighHeel() == true)
				.collect(Collectors.toList());
	}
}
