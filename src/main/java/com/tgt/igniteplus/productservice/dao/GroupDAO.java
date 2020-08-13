package com.tgt.igniteplus.productservice.dao;


import com.tgt.igniteplus.productservice.model.Group;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface GroupDAO extends CassandraRepository<Group, String>{
}
