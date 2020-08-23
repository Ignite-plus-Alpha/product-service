package com.tgt.igniteplus.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.igniteplus.productservice.dao.CategoryItemDAO;
import com.tgt.igniteplus.productservice.model.CategoryItemMap;
import com.tgt.igniteplus.productservice.service.CategoryItemService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.List;
import java.util.Optional;
import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryItemControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CategoryItemController categoryItemController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryItemController).build();
    }

    @Test
    public void getAll() throws Exception {
        CategoryItemMap categoryItemMap = new CategoryItemMap();
        categoryItemMap.setCategoryId("fiction");
        categoryItemMap.setGroupId("book");
        categoryItemMap.setItemId("f38354ff-27ec-495a-89ff-8189c6e43147");
        categoryItemMap.setImageUrl("https://kbimages1-a.akamaihd.net/70ee63f2-8c0a-48e6-8058-60d8cc633641/1200/1200/False/harry-potter-and-the-goblet-of-fire-6.jpg");
        categoryItemMap.setTitle("harry potter and the goblet of fire");
        categoryItemMap.setSeller("Hansel books");
        categoryItemMap.setSize(null);
        categoryItemMap.setPrice((float)500);
        categoryItemMap.setDescription(null);
        List<CategoryItemMap> allCatItem = singletonList(categoryItemMap);
        given(categoryItemController.getAll()).willReturn(allCatItem);
        mockMvc.perform(MockMvcRequestBuilders.get("/items")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void create() throws Exception  {
        CategoryItemMap categoryItemMap = new CategoryItemMap();
        categoryItemMap.setCategoryId("fiction");
        categoryItemMap.setGroupId("book");
        categoryItemMap.setItemId("f38354ff-27ec-495a-89ff-8189c6e43147");
        categoryItemMap.setImageUrl("https://kbimages1-a.akamaihd.net/70ee63f2-8c0a-48e6-8058-60d8cc633641/1200/1200/False/harry-potter-and-the-goblet-of-fire-6.jpg");
        categoryItemMap.setTitle("harry potter and the goblet of fire");
        categoryItemMap.setSeller("Hansel books");
        categoryItemMap.setSize(null);
        categoryItemMap.setPrice((float)500);
        categoryItemMap.setDescription(null);
        given(categoryItemController.create(categoryItemMap)).willReturn(categoryItemMap);
        mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .content(asJsonString(categoryItemMap))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void saveItems() throws Exception  {
        CategoryItemMap categoryItemMap = new CategoryItemMap();
        categoryItemMap.setCategoryId("fiction");
        categoryItemMap.setGroupId("book");
        categoryItemMap.setItemId("f38354ff-27ec-495a-89ff-8189c6e43147");
        categoryItemMap.setImageUrl("https://kbimages1-a.akamaihd.net/70ee63f2-8c0a-48e6-8058-60d8cc633641/1200/1200/False/harry-potter-and-the-goblet-of-fire-6.jpg");
        categoryItemMap.setTitle("harry potter and the goblet of fire");
        categoryItemMap.setSeller("Hansel books");
        categoryItemMap.setSize(null);
        categoryItemMap.setPrice((float)500);
        categoryItemMap.setDescription(null);
        List<CategoryItemMap> allCatItem = singletonList(categoryItemMap);
        given(categoryItemController.saveItems(allCatItem)).willReturn(allCatItem);
        mockMvc.perform(MockMvcRequestBuilders.post("/saveitems")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getItemsByItemId()throws Exception  {
        CategoryItemMap categoryItemMap = new CategoryItemMap();
        categoryItemMap.setCategoryId("fiction");
        categoryItemMap.setGroupId("book");
        categoryItemMap.setItemId("f38354ff-27ec-495a-89ff-8189c6e43147");
        categoryItemMap.setImageUrl("https://kbimages1-a.akamaihd.net/70ee63f2-8c0a-48e6-8058-60d8cc633641/1200/1200/False/harry-potter-and-the-goblet-of-fire-6.jpg");
        categoryItemMap.setTitle("harry potter and the goblet of fire");
        categoryItemMap.setSeller("Hansel books");
        categoryItemMap.setSize(null);
        categoryItemMap.setPrice((float)500);
        categoryItemMap.setDescription(null);
        given(categoryItemController.getItemsByItemId(categoryItemMap.getItemId())).willReturn(Optional.of(categoryItemMap));
        mockMvc.perform(MockMvcRequestBuilders.get("/items/fiction")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getItemsByCategoryId() throws Exception  {
        CategoryItemMap categoryItemMap = new CategoryItemMap();
        String categoryId="fiction";
        categoryItemMap.setGroupId("book");
        categoryItemMap.setItemId("f38354ff-27ec-495a-89ff-8189c6e43147");
        categoryItemMap.setImageUrl("https://kbimages1-a.akamaihd.net/70ee63f2-8c0a-48e6-8058-60d8cc633641/1200/1200/False/harry-potter-and-the-goblet-of-fire-6.jpg");
        categoryItemMap.setTitle("harry potter and the goblet of fire");
        categoryItemMap.setSeller("Hansel books");
        categoryItemMap.setSize(null);
        categoryItemMap.setPrice((float)500);
        categoryItemMap.setDescription(null);
        List<CategoryItemMap> allCatItem = singletonList(categoryItemMap);
        given(categoryItemController.getItemsByCategoryId(categoryId)).willReturn(allCatItem);
        mockMvc.perform(MockMvcRequestBuilders.get("/items/fiction")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getItemsByGroupIdCategoryId() throws Exception  {
        CategoryItemMap categoryItemMap = new CategoryItemMap();
        String categoryId="fiction";
        String groupId="book";
        categoryItemMap.setItemId("f38354ff-27ec-495a-89ff-8189c6e43147");
        categoryItemMap.setImageUrl("https://kbimages1-a.akamaihd.net/70ee63f2-8c0a-48e6-8058-60d8cc633641/1200/1200/False/harry-potter-and-the-goblet-of-fire-6.jpg");
        categoryItemMap.setTitle("harry potter and the goblet of fire");
        categoryItemMap.setSeller("Hansel books");
        categoryItemMap.setSize(null);
        categoryItemMap.setPrice((float)500);
        categoryItemMap.setDescription(null);
        List<CategoryItemMap> allCatItem = singletonList(categoryItemMap);
        given(categoryItemController.getItemsByGroupIdCategoryId(groupId,categoryId)).willReturn(allCatItem);
        mockMvc.perform(MockMvcRequestBuilders.get("/items/book/fiction")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getItemByGroupIdCategoryIdItemId() throws Exception  {
        CategoryItemMap categoryItemMap = new CategoryItemMap();
        String categoryId="fiction";
        String groupId="book";
        String itemId="f38354ff-27ec-495a-89ff-8189c6e43147";
        categoryItemMap.setImageUrl("https://kbimages1-a.akamaihd.net/70ee63f2-8c0a-48e6-8058-60d8cc633641/1200/1200/False/harry-potter-and-the-goblet-of-fire-6.jpg");
        categoryItemMap.setTitle("harry potter and the goblet of fire");
        categoryItemMap.setSeller("Hansel books");
        categoryItemMap.setSize(null);
        categoryItemMap.setPrice((float)500);
        categoryItemMap.setDescription(null);
        given(categoryItemController.getItemByGroupIdCategoryIdItemId(groupId,categoryId,itemId)).willReturn(categoryItemMap);
        mockMvc.perform(MockMvcRequestBuilders.get("/items/book/fiction/f38354ff-27ec-495a-89ff-8189c6e43147")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}