package com.tgt.igniteplus.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.igniteplus.productservice.controller.GroupController;
import com.tgt.igniteplus.productservice.dao.GroupDAO;
import com.tgt.igniteplus.productservice.model.Group;
import com.tgt.igniteplus.productservice.service.GroupService;
import org.junit.Before;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class GroupControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GroupService groupService;

    @Mock
    private GroupDAO groupDAO;

    @Mock
    private GroupController groupController;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
    }

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAllGroups() throws Exception {
        Group group = new Group();
        group.setGroupId("book");
        group.setImageUrl("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");

        List<Group> allGroup = singletonList(group);
        given(groupController.getAllGroups()).willReturn(allGroup);
        mockMvc.perform(MockMvcRequestBuilders.get("/groups")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void createGroup() throws Exception {
        Group group = new Group();
        group.setGroupId("book");
        group.setImageUrl("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");

        given(groupController.createGroup(group)).willReturn(group);
        mockMvc.perform(MockMvcRequestBuilders.post("/groups")
                .content(asJsonString(group))
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
    public void createGroups() throws Exception {
        Group group = new Group();
        group.setGroupId("book");
        group.setImageUrl("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");

        List<Group> allGroup = singletonList(group);
        given(groupController.createGroups(allGroup)).willReturn(allGroup);
        mockMvc.perform(MockMvcRequestBuilders.post("/savegroups")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void getGroupById() throws Exception{
        Group group = new Group();
        group.setGroupId("book");
        group.setImageUrl("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");

        given(groupController.getGroupBYId(group.getGroupId())).willReturn(Optional.of(group));
        mockMvc.perform(MockMvcRequestBuilders.get("/groups/book")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());


    }



}
