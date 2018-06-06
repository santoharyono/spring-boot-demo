package com.mitraiscdc.springmvcdemo.bootstrap;

import com.mitraiscdc.springmvcdemo.domain.*;
import com.mitraiscdc.springmvcdemo.repositories.CategoryRepository;
import com.mitraiscdc.springmvcdemo.repositories.RecipeRepository;
import com.mitraiscdc.springmvcdemo.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();

//        get UOM
        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByUom("Cup");

        if (!cupOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> pinchOptional = unitOfMeasureRepository.findByUom("Pinch");

        if (!pinchOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> teaSpoonOptional = unitOfMeasureRepository.findByUom("TeaSpoon");

        if (!teaSpoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tableSpoonOptional = unitOfMeasureRepository.findByUom("TableSpoon");

        if (!tableSpoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> ounceOptional = unitOfMeasureRepository.findByUom("Ounce");

        if (!ounceOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

//        get optionals
        UnitOfMeasure cup = cupOptional.get();
        UnitOfMeasure pinch = pinchOptional.get();
        UnitOfMeasure teaspoon = teaSpoonOptional.get();
        UnitOfMeasure tablespoon = tableSpoonOptional.get();
        UnitOfMeasure ounce = ounceOptional.get();

//        get categories
        Optional<Category> indonesianOptional = categoryRepository.findByDescription("Indonesian");

        if (!indonesianOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> americanOptional = categoryRepository.findByDescription("American");

        if (!americanOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> japaneseOptional = categoryRepository.findByDescription("Japanese");

        if (!japaneseOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> koreanOptional = categoryRepository.findByDescription("Korean");

        if (!koreanOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Category indonesian = indonesianOptional.get();
        Category american = americanOptional.get();
        Category japanese = japaneseOptional.get();
        Category korean = koreanOptional.get();

//        Recipe
        Recipe salad = new Recipe();
        salad.setDescription("Grilled Chicken Caesar Salad");
        salad.setPrepTime(10);
        salad.setCookTime(15);
        salad.setDifficulty(Difficulty.EASY);
        salad.setDirections("1 Marinate the chicken: In a medium bowl, whisk together the olive oil, lemon zest, garlic, salt, and pepper. Add the chicken and toss to coat. Marinate in the refrigerator, covered, for at least 20 minutes and up to 24 hours." +
                "\n" +
                "2 Brush the bread with oil: Combine the olive oil, garlic, salt, and pepper to a small bowl. Use a pastry brush to coat each side of the bread. Set aside on a tray." +
                "\n" +
                "3 Heat your grill: Preheat your grill to high heat to around 500°F with two zones for direct and indirect grilling." +
                "\n" +
                "4 Grill the bread: Grill the slices of bread over direct high heat for 2 minutes on each side. Remove from the grill and set aside while grilling the chicken." +
                "\n" +
                "5 Grill the chicken: Grill the chicken for 5 minutes on one side without disturbing, then flip and move the chicken to the cooler side of the grill. Cook 3 to 5 minutes or until internal temperature reaches 165ºF." +
                "\n" +
                "6 Finish the salad: Tear the romaine hearts into bite sized pieces and toss with the dressing in a large bowl. Divide the greens between plates and top with the grilled chicken, shaved Parmesan, grilled croutons. Finish with freshly cracked black pepper.");
        Notes saladNotes = new Notes();
        saladNotes.setNotes("This salad comes together quickly and easily with simple ingredients, many of which you probably already have on hand. I’m using boneless and skinless chicken thighs, which stay juicier than chicken breasts and cook very quickly." +
                "\n" +
                "You can prepare the chicken ahead of time, either by marinating it up to 24 hours in advance or by grilling the chicken up to two days before and serving it as a cold salad." +
                "\n" +
                "I use gluten-free sourdough to make my grilled croutons—which are basically slices of bread—but you can use any good crusty bread." +
                "\n" +
                "Stale bread works great for croutons as it crisps up beautifully. If yours is very fresh, that’s fine too. You’ll get a crispy exterior with a softer interior. I typically serve this with 2 or 3 slices of grilled “croutons” per person." +
                "\n" +
                "The chicken and croutons can be served hot, cold, or at room temperature. I like the contrast of the warm croutons and chicken with the crisp cold greens, but it’s great with cold chicken, too.");
        salad.addIngredient(new Ingredient("olive oil", new BigDecimal(1), cup));
        salad.addIngredient(new Ingredient("lemon", new BigDecimal(1), pinch));
        salad.addIngredient(new Ingredient("clove garlic", new BigDecimal(1), pinch));
        salad.addIngredient(new Ingredient("salt", new BigDecimal(1), teaspoon, salad));
        salad.addIngredient(new Ingredient("fresh ground black pepper", new BigDecimal(1), teaspoon));
        salad.addIngredient(new Ingredient("boneless skinless chicken", new BigDecimal(1), ounce));
        salad.addIngredient(new Ingredient("crusty baguette", new BigDecimal(1), ounce));
        salad.getCategories().add(american);
        salad.getCategories().add(japanese);

//        replaced with helper
//        saladNotes.setRecipe(salad);
        salad.setNotes(saladNotes);

        recipes.add(salad);

        Recipe pasta = new Recipe();
        pasta.setDescription("Pressure Cooker Pasta Primavera Recipe");
        pasta.setPrepTime(5);
        pasta.setCookTime(30);
        pasta.setDifficulty(Difficulty.MODERATE);
        pasta.setDirections("1 Steam the vegetables in the pressure cooker: Pour a cup of water into the pressure cooker. Combine the broccoli, bell pepper, and carrots in a steamer basket and place it in the pressure cooker.\n" +
                "\n" +
                "Secure the lid in its sealed position, then select the Steam program and set the cooking time for 1 minute at low pressure. (It’ll take about 10 minutes for the pot to come to pressure before the cooking program begins.)\n" +
                "\n" +
                "When the cooking program ends, perform a quick pressure release by moving the lid to its venting position. When the pressure has fully released, open the pot and lift the steamer basket out of the pot using heatproof oven mitts. After removing the vegetables, lift the inner pot out of the pressure cooker housing, pour out the water, and return the inner pot to the housing." +
                "\n" +
                "2 Cook the pasta: To the now-empty pressure cooker, add the pasta and broth. Secure the lid in its sealed position, then select the Manual program and set the cooking time for 5 minutes at high pressure. (It’ll take about 10 minutes for the pot to come to pressure before the cooking program begins.)\n" +
                "\n" +
                "When the cooking program ends, let the pressure release naturally for 5 minutes, then move the lid to its venting position to release the remaining steam. When the pressure has fully released, open the pot." +
                "\n" +
                "3 Mix everything together and serve: Add the steamed vegetables, olive oil, parsley, Parmesan cheese, and black pepper to the pot. Stir gently until the vegetables and pasta are fully combined and evenly coated.\n" +
                "\n" +
                "Spoon the pasta into serving bowls and serve hot.");
        Notes pastaNotes = new Notes();
        pastaNotes.setNotes("Using a stovetop pressure cooker is not advisable for this recipe, as the higher pressure tends to create more foaming and sputtering issues with foods such as pasta.");
        pasta.addIngredient(new Ingredient("broccoli", new BigDecimal(8), ounce));
        pasta.addIngredient(new Ingredient("red bell pepper", new BigDecimal(8), ounce));
        pasta.addIngredient(new Ingredient("carrots", new BigDecimal(8), ounce));
        pasta.addIngredient(new Ingredient("penne pasta", new BigDecimal(1), ounce));
        pasta.addIngredient(new Ingredient("low sodium broth",new BigDecimal(4), cup));
        pasta.addIngredient(new Ingredient("extra virgin olive oil", new BigDecimal(4), tablespoon));
        pasta.addIngredient(new Ingredient("chopped parsley", new BigDecimal(2), tablespoon));
        pasta.getCategories().add(american);
        pasta.getCategories().add(indonesian);
        pasta.getCategories().add(korean);

//        pastaNotes.setRecipe(pasta);
        pasta.setNotes(pastaNotes);
        recipes.add(pasta);

        return recipes;
    }
}
