package com.tgt.igniteplus.productservice.controller;

import com.tgt.igniteplus.productservice.model.CategoryItemMap;
import com.tgt.igniteplus.productservice.service.CategoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class CategoryItemController {

    @Autowired
    private CategoryItemService categoryItemService;

    @Autowired
    public CategoryItemController(CategoryItemService categoryItemService) {
        this.categoryItemService = categoryItemService;
    }

        //getAllCatItem
        @GetMapping("/items")
        public List<CategoryItemMap> getAll(){
            return categoryItemService.getAll();
        }

        //createGroup-cat
        @PostMapping("/items")
        public CategoryItemMap create(@RequestBody CategoryItemMap categoryItemMap){
            return categoryItemService.create(categoryItemMap);
        }

    //save all items
    @PostMapping("/saveitems")
    public List<CategoryItemMap> saveItems(@RequestBody List<CategoryItemMap> categoryItemMaps){
        return categoryItemService.saveAllItems(categoryItemMaps);
    }

    //get an item by item id
    @GetMapping("/item/{id}")
    public Optional<CategoryItemMap> getItemsByItemId(@PathVariable("id") String id){
        return categoryItemService.getItemByItemId(id);
    }

    //get list of items by category id
    @GetMapping("/items/{categoryId}")
    public List<CategoryItemMap> getItemsByCategoryId(@PathVariable("categoryId") String categoryId){
        return categoryItemService.getItemsByCategoryId(categoryId);
    }

    //get list of items from group/category
    @GetMapping("/items/{groupId}/{categoryId}")
    public List<CategoryItemMap> getItemsByGroupIdCategoryId(@PathVariable("groupId") String groupId,@PathVariable("categoryId") String categoryId){
        return categoryItemService.getItemsByCategoryIdGroupId(groupId,categoryId);
    }

    //get item by group/category/itemid
    @GetMapping("/items/{groupId}/{categoryId}/{itemId}")
    public CategoryItemMap getItemByGroupIdCategoryIdItemId(@PathVariable("groupId") String groupId,@PathVariable("categoryId") String categoryId,@PathVariable("itemId") String itemId){
        return categoryItemService.getItemByCatIdGrpIdItemId(groupId,categoryId,itemId);
    }


}
