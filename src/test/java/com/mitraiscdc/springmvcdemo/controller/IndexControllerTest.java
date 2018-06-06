package com.mitraiscdc.springmvcdemo.controller;

import com.mitraiscdc.springmvcdemo.service.RecipeService;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @InjectMocks
    IndexController indexController;

    @Test
    public void getIndex() {
        String viewName = indexController.getIndex(model);
        assertThat(viewName).isEqualTo("index");
        verify(recipeService).getAllRecipe();
        verify(model).addAttribute(eq("recipes"), anyList());
    }

    @Test
    public void getIndexMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @After
    public void tearDown() throws Exception {
//        verifyNoMoreInteractions(recipeService);
    }
}