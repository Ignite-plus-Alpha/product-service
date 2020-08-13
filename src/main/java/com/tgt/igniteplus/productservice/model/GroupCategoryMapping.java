package com.tgt.igniteplus.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("group_category")
public class GroupCategoryMapping {

    //in group-out find categories per by group
    //display categories for a particular group
    //men -shirt-image
    //men-pant

    @PrimaryKeyColumn(name = "group",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String groupId;
    @PrimaryKeyColumn(name = "category",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String categoryId;
    private String imageUrl;

}
