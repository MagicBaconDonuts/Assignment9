package com.assignment9.service;

import com.assignment9.domain.Recipe;

public class RecipeService {

	public Recipe createRecipe(Integer cookingMinutes, Boolean dairyFree, Boolean gluteenFree, String instructions, Double preparationMinutes, Double pricePerServings,
			   Integer readyInMinutes, Integer servings, Double spoonacularScore, String title, Boolean vegan, Boolean vegetarian) {
		Recipe recpie = new Recipe();
		recpie.setCookingMinutes(cookingMinutes);
		recpie.setDairyFree(dairyFree);
		recpie.setGlutenFree(gluteenFree);
		recpie.setInstructions(instructions);
		recpie.setPreparationMinutes(preparationMinutes);
		recpie.setPricePerServing(pricePerServings);
		recpie.setReadyInMinutes(readyInMinutes);
		recpie.setServings(servings);
		recpie.setSpoonacularScore(spoonacularScore);
		recpie.setTitle(title);
		recpie.setVegan(vegan);
		recpie.setVegetarian(vegetarian);
		return recpie;
	}
}
