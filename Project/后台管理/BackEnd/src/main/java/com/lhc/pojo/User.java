package com.lhc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private String password;
    @TableField("avatar_url")
    private String avatarUrl;
    @TableField("avatar_hash")
    private String avatarHash;
    @TableField("create_time")
    private Timestamp createTime;
}