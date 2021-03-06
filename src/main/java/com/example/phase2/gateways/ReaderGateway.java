package com.example.phase2.gateways;

import com.example.phase2.entity.Recipe;

import java.io.IOException;
import java.util.List;

public interface ReaderGateway {

    List<Recipe> getRecipes() throws IOException, ClassNotFoundException;

}
