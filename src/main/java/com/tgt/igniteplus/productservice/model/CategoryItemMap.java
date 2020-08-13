package com.tgt.igniteplus.productservice.model;


import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("category_item")
public class CategoryItemMap {

    //in categoryId - out list of items in a particular category
    @PrimaryKeyColumn(name = "categoryId",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String categoryId;
    @PrimaryKeyColumn(name = "groupId",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String groupId;
//
    @PrimaryKeyColumn(name = "itemId",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private String itemId = UUID.randomUUID().toString();

//   private String productCode;
    private String imageUrl;
     private String title;
    private String seller;
    private Set<String> size;
    private Float price;
    private Map<String,String> description;
    }