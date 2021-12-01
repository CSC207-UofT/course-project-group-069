package meals.use_case;
import meals.entity.Recipe;

import java.util.List;

public class RecipePrinter {
    public String print(List<Recipe> recipes){
        StringBuilder res = new StringBuilder();
        for(Recipe recipe:recipes){
            res.append(recipe.toString());
        }
        String str = res.toString();
        return str;
    }
}
