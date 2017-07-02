package de.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLearning {
	List<ShoePair> shoePairs = Arrays.asList(
			new ShoePair("black", 38, true),
			new ShoePair("red", 39, true),
			new ShoePair("black", 38, false),
			new ShoePair("red", 38, true),
			new ShoePair("white", 39, false));

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
		return shoePairs
				.stream()
				.filter(item -> item.getSize() == 38 && item.isHighHeel() == true)
				.collect(Collectors.toList());
	}

	public List<ShoePair> makeNewShoesInMySize() {
		return shoePairs
				.stream()
				.map(item -> new ShoePair(item.getColor(), 38, false))
				.collect(Collectors.toList());
	}

	public List<ShoePair> getWhiteShoes() {
		return Stream.of(
				new ShoePair("white", 39, false),
				new ShoePair("black", 39, false),
				new ShoePair("white", 38, false),
				new ShoePair("red", 38, false))
				.filter(item -> item.getColor() == "white")
				.collect(Collectors.toList());
	}
}
