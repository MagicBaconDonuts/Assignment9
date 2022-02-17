package com.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.assignment9.domain.Recipe;

@Service
public class FileService {
	
	public FileService() {
	}
	
	public List<Recipe> readFile(String fileName) throws IOException {
		RecipeService recipeService = new RecipeService();
		Reader in = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withHeader().parse(in);
		List<Recipe> recipes = new ArrayList<>();
		for (CSVRecord record : records) {
			recipes.add(recipeService.createRecipe(Integer.parseInt(record.get(0)), Boolean.parseBoolean(record.get(1)), Boolean.parseBoolean(record.get(2)), 
					record.get(3), Double.parseDouble(record.get(4)), Double.parseDouble(record.get(5)), Integer.parseInt(record.get(6)), Integer.parseInt(record.get(7)),
					Double.parseDouble(record.get(8)), record.get(9), Boolean.parseBoolean(record.get(10)), Boolean.parseBoolean(record.get(11))));
			/////////////////////////////////////Testing//////////////////////////////////
//			System.out.println(record.get(10));
//			System.out.println(record.get(11));
		}
		return recipes;
	}
	
}
