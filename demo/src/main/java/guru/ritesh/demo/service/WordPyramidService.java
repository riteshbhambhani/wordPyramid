package guru.ritesh.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.ritesh.demo.WordUtil;

@Service
public class WordPyramidService {

	public Boolean isWordPyramid(String input, Boolean useJava7) {

		boolean isValidInput = WordUtil.validateInput(input);

		if (!isValidInput) {
			System.out.println("Not a Valid Input");
			return false;
		}

		if (useJava7) {
			return wordMakesPyramidJava7(input);
		}else {
			return wordMakesPyramidJava8(input);
		}
		

	}

	// Order should be 1,2,3,4....
	private boolean areKeyInChronologicalOrder(SortedSet<Integer> wordCountSet) {

		int prevValue = 1;

		for (Integer i : wordCountSet) {

			if (i != prevValue) {
				return false;
			}
			prevValue++;
		}
		return true;

	}
	/*Stream used to make Unique char list. */
	private Boolean wordMakesPyramidJava8(String input) {

		// find distinct. List cannot be null
		List<Character> uniqueChars = input.chars().distinct().mapToObj(c -> (char) c).collect(Collectors.toList());
		SortedSet<Integer> wordCountSet = new TreeSet<Integer>();

		for (char c : uniqueChars) {
			// Each Char in the List
			int count = 0, fromIndex = 0;
			while ((fromIndex = input.indexOf(c, fromIndex)) != -1) {
				count++;
				fromIndex++;
			}

			boolean canAddValue = (wordCountSet.isEmpty() || !wordCountSet.contains(count)) ? true : false;

			if (!canAddValue) {
				return false;
			}
			wordCountSet.add(count);
		}
		return areKeyInChronologicalOrder(wordCountSet);
	}

	private Boolean wordMakesPyramidJava7(String input) {

		List<Character> evaluatedElements = new ArrayList<Character>();
		SortedSet<Integer> wordCountSet = new TreeSet<Integer>();

		char[] elements = input.toCharArray();

		for (int outerLoopIndex = 0; elements.length > outerLoopIndex; outerLoopIndex++) {
			char outerElement = elements[outerLoopIndex];
			int count = 0;

			if (evaluatedElements.contains(outerElement)) {
				// Already evaluated
				continue;
			}
			evaluatedElements.add(outerElement);
			for (int innerLoopIndex = 0; elements.length > innerLoopIndex; innerLoopIndex++) {
				char innerElement = elements[innerLoopIndex];
				if (innerElement == outerElement) {
					count++;
				}

			}
			if (wordCountSet.contains(count)) {
				return false;
			}

			wordCountSet.add(count);

		}
		return areKeyInChronologicalOrder(wordCountSet);
	}

}
