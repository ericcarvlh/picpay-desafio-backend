package com.picpaysimplificado.service;

import com.picpaysimplificado.DTO.UserDTO;
import com.picpaysimplificado.domain.user.TypeUser;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service // indica que eh uma classe de servico
public class UserService {
    @Autowired // faz a injecao do repository
    private UserRepository repository;

    public void validadeTransaction(User sender, BigDecimal amout) throws Exception {
        if (sender.getTypeUser() == TypeUser.MERCHANT)
            throw new Exception("Usuario do tipo Lojista nao esta autorizado a realizar transacao.");

        if (sender.getBalance().compareTo(amout) < 0)
            throw new Exception("Saldo insuficiente.");
    }

    public User findUserByCdUser(Long cdUser) throws Exception {
        return this.repository.findUserByCdUser(cdUser).orElseThrow((() -> new Exception(("Usuario nao encontrado."))));
    }

    public void saveUser(User user) {
        this.repository.save(user);
    }

    public User createUser(UserDTO userDTO) {
        User newUser = new User(userDTO);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
