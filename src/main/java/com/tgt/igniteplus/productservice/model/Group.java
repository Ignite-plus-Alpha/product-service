package com.tgt.igniteplus.productservice.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("group")
public class Group {

    //table -  each row is a group
    //pass group_id to group_category_mapping to get list of categories for this group

    @PrimaryKey
    private String groupId;
    private String imageUrl;

}
