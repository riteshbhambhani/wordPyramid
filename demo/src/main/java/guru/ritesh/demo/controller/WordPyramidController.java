package guru.ritesh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import guru.ritesh.demo.service.WordPyramidService;

@RestController
@RequestMapping("/pyramid")
public class WordPyramidController {
	
	@Autowired
	private WordPyramidService wordPyramidService;
	
	@GetMapping("/{word}")
	@ResponseBody
	public Boolean isPyramid(@PathVariable String word, @RequestParam(required = false) boolean useJava7) {		
		return wordPyramidService.isWordPyramid(word, useJava7);
	}
	
	@GetMapping("/error")
	@ResponseBody
	public String errorOccurred() {
		return "Something went wrong";
	}



	

}
