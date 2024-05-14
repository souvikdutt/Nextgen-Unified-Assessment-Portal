package com.epam.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import com.epam.model.RoleEnum;

@Entity
@Table(name = "Role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleEnum roles;

}
