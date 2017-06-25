import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTesting {

	public static void main(String[] args) {

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream()
				.filter(item -> item.startsWith("a"))
				.collect(Collectors.toList())
				.forEach(System.out::println);

		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		List<Character> charAbcList = abc
				.chars()
				.mapToObj(character -> (char) character)
				.collect(Collectors.toList());

		System.out.println(charAbcList);

		charAbcList.stream()
				.map(character -> character.toString() + "A")
				.collect(Collectors.toList())
				.forEach(System.out::print);

	}

}
