package com.picpaysimplificado.DTO;

import com.picpaysimplificado.domain.user.TypeUser;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, String email, String password, BigDecimal balance, TypeUser typeUser) {
}
