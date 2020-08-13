package com.tgt.igniteplus.productservice.service;


import com.tgt.igniteplus.productservice.ProductException.ItemNotFoundException;
import com.tgt.igniteplus.productservice.dao.GroupDAO;
import com.tgt.igniteplus.productservice.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class GroupService {


    private GroupDAO groupDAO;

    @Autowired
    public GroupService(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    //getAllGroups
    public List<Group> getAll(){
        return groupDAO.findAll();
    }

    //createGroup
    public Group create(Group group){
        return groupDAO.save(group);
    }

    //createGroups
    public List<Group> saveAllGroups(List<Group> groups){
        return groupDAO.saveAll(groups);
    }

    //getGroupByID
    public Optional<Group> getById(String id) throws ItemNotFoundException {
        Optional<Group> group=groupDAO.findById(id);
        if(!group.isPresent())
            throw new ItemNotFoundException("group not found");
        return group;
    }

    //deleteGroupById
    public void deleteById(String id) {
        Optional<Group> group=groupDAO.findById(id);
        if(!group.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"group not found in repo,enter correct details");
        }
        groupDAO.deleteById(id);
    }


}
