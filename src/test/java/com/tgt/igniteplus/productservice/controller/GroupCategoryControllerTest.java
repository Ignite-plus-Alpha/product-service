package com.tgt.igniteplus.productservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.igniteplus.productservice.dao.GroupCategoryDAO;

import com.tgt.igniteplus.productservice.model.GroupCategoryMapping;
import com.tgt.igniteplus.productservice.service.GroupCategoryService;

import org.junit.Before;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static java.util.Collections.singletonList;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class GroupCategoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GroupCategoryService groupCategoryService;

    @Mock
    private GroupCategoryDAO groupCategoryDAO;

    @Mock
    private GroupCategoryController groupCategoryController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(groupCategoryController).build();
    }

    @Test
    public void getAll() throws Exception {
        GroupCategoryMapping groupCategoryMapping = new GroupCategoryMapping();
        groupCategoryMapping.setGroupId("book");
        groupCategoryMapping.setCategoryId("autobiography");
        groupCategoryMapping.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/81Z5fX7qieL.jpg");

        List<GroupCategoryMapping> allGroupCat = singletonList(groupCategoryMapping);
        given(groupCategoryController.getAll()).willReturn(allGroupCat);
        mockMvc.perform(MockMvcRequestBuilders.get("/categories")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void create() throws Exception {
        GroupCategoryMapping groupCategoryMapping = new GroupCategoryMapping();
        groupCategoryMapping.setGroupId("book");
        groupCategoryMapping.setCategoryId("autobiography");
        groupCategoryMapping.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/81Z5fX7qieL.jpg");

        given(groupCategoryController.create(groupCategoryMapping)).willReturn(groupCategoryMapping);
        mockMvc.perform(MockMvcRequestBuilders.post("/categories")
                .content(asJsonString(groupCategoryMapping))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    public static String asJsonString ( final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    public void saveCategories() throws Exception {
        GroupCategoryMapping groupCategoryMapping = new GroupCategoryMapping();
        groupCategoryMapping.setGroupId("book");
        groupCategoryMapping.setCategoryId("autobiography");
        groupCategoryMapping.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/81Z5fX7qieL.jpg");

        List<GroupCategoryMapping> allGroupCat = singletonList(groupCategoryMapping);
        given(groupCategoryController.saveCategories(allGroupCat)).willReturn(allGroupCat);
        mockMvc.perform(MockMvcRequestBuilders.post("/savecategories")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void getCategoriesByGroupId() throws Exception {
        GroupCategoryMapping groupCategoryMapping = new GroupCategoryMapping();
        groupCategoryMapping.setGroupId("book");
        groupCategoryMapping.setCategoryId("autobiography");
        groupCategoryMapping.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/81Z5fX7qieL.jpg");

        List<GroupCategoryMapping> allGroupCat = singletonList(groupCategoryMapping);
        given(groupCategoryController.getCategoriesByGroupId(groupCategoryMapping.getGroupId())).willReturn(allGroupCat);
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/book")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());


    }

}