package com.tgt.igniteplus.productservice.controller;


import com.tgt.igniteplus.productservice.model.GroupCategoryMapping;
import com.tgt.igniteplus.productservice.service.GroupCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GroupCategoryController {

    @Autowired
    private GroupCategoryService groupCategoryService;


    //getAll Groups-Category
    @GetMapping("/categories")
    public List<GroupCategoryMapping> getAll(){
        return GroupCategoryService.getAll();
    }

    //create Group-Category
    @PostMapping("/categories")
    public GroupCategoryMapping create(@RequestBody GroupCategoryMapping groupCategoryMapping){
        return groupCategoryService.create(groupCategoryMapping);
    }
    //create Group-Category
    @PostMapping("/savecategories")
    public List<GroupCategoryMapping> saveCategories(@RequestBody List<GroupCategoryMapping> groupCategoryMappings){
        return groupCategoryService.saveAllCategories(groupCategoryMappings);
    }

    //get category mapped to a group by groupId
    @GetMapping("/categories/{id}")
    public List<GroupCategoryMapping> getCategoriesByGroupId(@PathVariable("id") String groupId){
            return groupCategoryService.getAllCategoriesByGroupId(groupId);
    }

}
