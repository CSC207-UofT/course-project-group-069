# course-project-group-069
course-project-group-069 created by GitHub Classroom
## Instruction for our project
#### 1. Check the database first,  which is a file called [recipes - Sheet1.csv](https://github.com/CSC207-UofT/course-project-group-069/blob/main/recipes%20-%20Sheet1.csv). Since we decided not to have too many recipes in our database for increased efficiency, it may be hard to find to a recipe by adding random ingredients to the fridge, which is why viewing this file is important. It contains various recipes with different ingredients that the user can add to their fridge in order to use Recipe Finder. The format for each recipe is: 'Recipe Name, Ingredients, Directions'. These are separated by commas, and the ingredients are separated by a vertical bar (|). If the user adds all the ingredients required for one particular recipe, they can then use the "Find Recipe" button to return that recipe. Futhermore by searching up a recipe name (that is available in the database) in find recipe -> get direction functionality could also display user the recipe details which includes the ingredients the user need for that recipe. 

#### 2. The Main code of our project is in [course-project-group-069/src/main/java/com/example/phase2/com/example/phase2](https://github.com/CSC207-UofT/course-project-group-069/tree/main/src/main/java/com/example/phase2). Each layer of clean architecture is packaged by a file, so when you go through the whole project, you can easily know the layer of the codes. To directly run our code, go to the gui package and run GUI.java.

#### 3. Our tests path is  [course-project-group-069/src/test/java](https://github.com/CSC207-UofT/course-project-group-069/tree/main/src/main/java/com/example/phase2), there are two packages including the entity tests and use case tests, and ControllerPresenterTest contains the tests for Controller and Presenter. The test cases assume the serialization file to be at its default state. If the tests fail, please run UserListSerialization class to reset the userlist.ser database and try again. 

#### 4. All files contain Javadoc, so it will be easy to go through the whole project.

#### 5. If there are any damages to the serialization database userlist.ser, please run UserListSerialization class located in com.example.phase2 module to reset database. 
