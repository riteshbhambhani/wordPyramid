package guru.ritesh.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WordUtilTest {


	@Test
	public void whenInvalidWord_thenShouldBeFalse() {

		String inputWord = "abbcccddd234%%";
		Boolean output = WordUtil.validateInput(inputWord);
		assertFalse(output);
	}

	@Test
	public void whenValidWord_thenShouldBeTrue() {

		String inputWord = "banana";
		Boolean output = WordUtil.validateInput(inputWord);
		assertTrue(output);
	}

}
