package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@ApiModel(value = "User",description = "Kullanıcı ekleme için kullanılır")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ApiModelProperty(value = "Adı")
    private String firstName;
    @ApiModelProperty(value = "Soyadı")
    private String lastName;
    @ApiModelProperty(value = "Email")
    private String email;
    @ApiModelProperty(value = "Şifre")
    private String password;
    @ApiModelProperty(value = "Telefon")
    private String phone;
    @ApiModelProperty(value = "Durum")
    private boolean status;

    private boolean enabled;
    private boolean tokenExpired;


    @ApiModelProperty(value = "Rol")
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<com.works.entities.Role> roles;

}
