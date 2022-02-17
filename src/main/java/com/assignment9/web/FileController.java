package com.assignment9.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment9.domain.Recipe;
import com.assignment9.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/gluten-free")
	public Stream<Recipe> returnGlutenFree() throws IOException{
		List<Recipe> recipes = fileService.readFile("recipes.txt");	
		return recipes.stream()
			   .filter(gFree -> gFree.getGlutenFree().equals(true));
	}
	@GetMapping("/vegan")
	public Stream<Recipe> returnVegan() throws IOException{
		List<Recipe> recipes = fileService.readFile("recipes.txt");	
		return recipes.stream()
					  .filter(vegan -> vegan.getVegan().equals(true));
	}
	@GetMapping("/vegan-and-gluten-free")
	public Stream<Recipe> returnVeganAndGlutenFree() throws IOException{
		List<Recipe> recipes = fileService.readFile("recipes.txt");	
		return recipes.stream()
				  .filter(vAndgFree -> vAndgFree.getVegan().equals(true) && vAndgFree.getGlutenFree().equals(true));
	}
	@GetMapping("/vegetarian")
	public Stream<Recipe> returnVegetarian() throws IOException{
		List<Recipe> recipes = fileService.readFile("recipes.txt");	
		return recipes.stream()
				  .filter(vegetarian -> vegetarian.getVegetarian().equals(true));
	}
	@GetMapping("/all-recipes")
	public List<Recipe> returnAllRecpies() throws IOException{
		List<Recipe> recipes = fileService.readFile("recipes.txt");	
		return recipes;
	}

	@GetMapping("")
	public String printOutToWeb() {
		return "Hello to the web";
	}
}
