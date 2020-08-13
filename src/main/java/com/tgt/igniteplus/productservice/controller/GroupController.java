package com.tgt.igniteplus.productservice.controller;

import com.tgt.igniteplus.productservice.ProductException.ItemNotFoundException;
import com.tgt.igniteplus.productservice.model.Group;
import com.tgt.igniteplus.productservice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/hello")
    public String sayHello(){
        return "hello world";
    }

    //getAllGroups
    @GetMapping("/groups")
    public List<Group> getAllGroups(){
        return groupService.getAll();
    }

    //createGroup
    @PostMapping("/groups")
    public Group createGroup(@RequestBody Group group){
        return groupService.create(group);
    }

    //save list of groups at once
    @PostMapping("/savegroups")
    public List<Group> createGroups(@RequestBody List<Group> groups){
        return groupService.saveAllGroups(groups);
    }

    //get group by id
    @GetMapping("/groups/{id}")
    public Optional<Group> getGroupBYId( @PathVariable("id") String id){
        try {
            return groupService.getById(id);
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
//
//    //deleteGroupById
//    @DeleteMapping("/groups/{id}")
//    public void deleteGroupById(@PathVariable("id") String id)throws ItemNotFoundException {
//        groupService.deleteById(id);
//    }
}
