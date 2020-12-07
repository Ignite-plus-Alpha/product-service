package com.tgt.igniteplus.productservice.service;


import com.tgt.igniteplus.productservice.dao.CategoryItemDAO;
import com.tgt.igniteplus.productservice.model.CategoryItemMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//class SortByPrice implements Comparator<CategoryItemMap>
//{
//    public int compare(CategoryItemMap a, CategoryItemMap b)
//    {
//        return (int) (a.getPrice() - b.getPrice());
//    }
//}
class SortByPrice implements Comparator<CategoryItemMap>
{
    @Override
    public int compare(CategoryItemMap obj1, CategoryItemMap obj2) {
        return obj1.getPrice().compareTo(obj2.getPrice());
    }
}

@Service
public class CategoryItemService {


    private static CategoryItemDAO categoryItemDAO;

    @Autowired
    public CategoryItemService(CategoryItemDAO categoryItemDAO) {
        this.categoryItemDAO = categoryItemDAO;
    }

        //getAllItemCategoryItem
        public static List<CategoryItemMap> getAll(){
            return categoryItemDAO.findAll();
        }

        //createCategoryItem
        public CategoryItemMap create(CategoryItemMap categoryItemMap){

        return categoryItemDAO.save(categoryItemMap);
        }
        //add a list of items
        public List<CategoryItemMap> saveAllItems(List<CategoryItemMap> categoryItemMaps){
            return categoryItemDAO.saveAll(categoryItemMaps);
        }

        //getItemByItemId
            public Optional<CategoryItemMap> getItemByItemId(String ItemId) {
                Optional<CategoryItemMap>  item = categoryItemDAO.findByItemId(ItemId);
            return item;
        }

        //get Item list for a category (eg all shirts (both men/women))
        public List<CategoryItemMap> getItemsByCategoryId(String categoryId) {
        List<CategoryItemMap>  items = categoryItemDAO.findByCategoryId(categoryId);
        return items;
        }

        //get Item list for a category (eg shirt)
    public List<CategoryItemMap> getItemsByCategoryIdGroupId(String groupId,String categoryId) {
        List<CategoryItemMap>  items = categoryItemDAO.findByCategoryId(categoryId);
        List<CategoryItemMap> itemsFilteredByGroup =  new ArrayList<>();
        for (CategoryItemMap item:items
             ) {
            if(item.getGroupId().equals(groupId))
                itemsFilteredByGroup.add(item);
        }
        return itemsFilteredByGroup;
    }

    //get item by groupId->categoryId->itemId
    public CategoryItemMap getItemByCatIdGrpIdItemId(String groupId,String categoryId,String itemId) {
        List<CategoryItemMap>  items = categoryItemDAO.findByCategoryId(categoryId);
        CategoryItemMap filteredItem = null;
        for (CategoryItemMap item:items
        ) {
            if(item.getGroupId().equals(groupId) && item.getItemId().equals(itemId))
            { filteredItem = item;
            break;
            }
        }
        return filteredItem;
    }


        public List<CategoryItemMap> sortItemsByPrice(List<CategoryItemMap> categoryItemMaps,String criteria){
        if(criteria.equals("price-inc"))
        {
            Collections.sort(categoryItemMaps,new SortByPrice());
        }

        else if(criteria.equals("price-dec")) {
            Comparator<CategoryItemMap> cmp = Collections.reverseOrder(new SortByPrice());
            Collections.sort(categoryItemMaps, cmp);
            }
            return categoryItemMaps;
        }
}


