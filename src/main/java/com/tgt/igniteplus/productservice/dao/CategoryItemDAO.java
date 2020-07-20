package com.tgt.igniteplus.productservice.dao;


import com.tgt.igniteplus.productservice.model.CategoryItemMap;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryItemDAO extends CassandraRepository<CategoryItemMap, String> {
   //fetch list of items belonging to a category by its categoryId
    List<CategoryItemMap> findByCategoryId(String categoryId);

    //get an item by Item id
    @Query(allowFiltering=true)
    Optional<CategoryItemMap> findByItemId(String itemId);
}