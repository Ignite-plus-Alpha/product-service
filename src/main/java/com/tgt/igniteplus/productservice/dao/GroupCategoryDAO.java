package com.tgt.igniteplus.productservice.dao;


import com.tgt.igniteplus.productservice.model.GroupCategoryMapping;
import org.springframework.data.cassandra.repository.CassandraRepository;


import java.util.List;

public interface GroupCategoryDAO extends CassandraRepository<GroupCategoryMapping, String> {

    //fetch list of categories belong to a group by its groupId
    List<GroupCategoryMapping> findByGroupId(String groupId);

}
