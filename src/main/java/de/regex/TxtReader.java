package de.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class TxtReader {

	public List<String> findRegExMatchingStringsInText(String regEx, String text) {

		List<String> matchList = new ArrayList<>();
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(text);

		Predicate<? super Object> predicate = Objects::nonNull;
		Function<? super Object, ? extends Object> function = Function.identity();
		Lists.newArrayList().stream().filter(predicate).map(function).collect(Collectors.toList());

		while (matcher.find()) {
			matchList.add(matcher.group());
		}
		return matchList;
	}

}
