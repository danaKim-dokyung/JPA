package com.moon.shop.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private int id; //auto_increment

    @Column(nullable = false, length = 30, unique = true, name="member_username")
    private String memberUsername;

    @Column(nullable = false, length = 100, name="password")
    private String password;

    @Column(nullable = false, length = 30, name="member_phone")
    private String memberPhone;

    @Column(nullable = false, length = 30,  name="member_name")
    private String memberName;

    @CreationTimestamp
    private Timestamp createDate;

    /*
    //USER, ADMIN
    @Enumerated(EnumType.STRING)
    private RoleType roles;
     */

    private String roles; //USER, ADMIN

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }


}
