package com.tgt.igniteplus.productservice.service;


import com.tgt.igniteplus.productservice.dao.GroupCategoryDAO;
import com.tgt.igniteplus.productservice.model.GroupCategoryMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class GroupCategoryService {

    private static GroupCategoryDAO groupCategoryDAO;

    @Autowired
    public GroupCategoryService(GroupCategoryDAO groupCategoryDAO) {
        this.groupCategoryDAO = groupCategoryDAO;
    }

    //getAllGroupsCategories
    public static List<GroupCategoryMapping> getAll(){
        return groupCategoryDAO.findAll();
    }

    //createGroupCategory
    public GroupCategoryMapping create(GroupCategoryMapping groupCategoryMapping){
        return groupCategoryDAO.save(groupCategoryMapping);
    }

    //save list of categories at once
    public List<GroupCategoryMapping> saveAllCategories(List<GroupCategoryMapping> groupCategoryMappings){
        return groupCategoryDAO.saveAll(groupCategoryMappings);
    }



     //getGroupByID
    public List<GroupCategoryMapping> getAllCategoriesByGroupId(String groupId)  {
        List<GroupCategoryMapping> groupCategoryMapping=groupCategoryDAO.findByGroupId(groupId);
               return groupCategoryMapping;
    }


}
