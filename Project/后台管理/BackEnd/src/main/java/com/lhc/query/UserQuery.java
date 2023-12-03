package com.lhc.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {
    private Integer pageNum;
    private Integer pageSize;
    private String name;
    private String email;
    private String address;
}
