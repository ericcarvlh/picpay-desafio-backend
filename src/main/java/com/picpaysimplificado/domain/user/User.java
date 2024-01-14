package com.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name="tbl_users") // representa uma entidade em nossa base de dados
@Table(name="tbl_users")
@Getter
@Setter
@AllArgsConstructor // construtor para receber todos os parametros da classe
@EqualsAndHashCode(of="cd_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_user")
    private long cdUser;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

}
