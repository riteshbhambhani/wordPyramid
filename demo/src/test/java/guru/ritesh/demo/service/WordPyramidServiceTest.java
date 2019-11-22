package guru.ritesh.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WordPyramidServiceTest {


	@SpyBean
	private WordPyramidService wordService;

   
	@Test
	public void whenValidWord_thenShouldReturnTrueWithJava7() {
	    String word = "banana";
	    Boolean pyramidWord = wordService.isWordPyramid(word, true);
	  
	    assertTrue(pyramidWord);
	 }
	
	@Test
	public void whenValidWord_thenShouldReturnTrueWithJava8() {
	    String word = "banana";
	    Boolean pyramidWord = wordService.isWordPyramid(word, false);
	  
	    assertTrue(pyramidWord);
	 }
	
	@Test
	public void whenInvalidWord_thenShouldReturnFalseWithJava7() {
	    String word = "bandana";
	    Boolean pyramidWord = wordService.isWordPyramid(word, true);
	  
	    assertFalse(pyramidWord);
	 }
	
	@Test
	public void whenInvalidWord_thenShouldReturnFalseWithJava8() {
	    String word = "bandana";
	    Boolean pyramidWord = wordService.isWordPyramid(word, false);
	  
	    assertFalse(pyramidWord);
	 }

}
