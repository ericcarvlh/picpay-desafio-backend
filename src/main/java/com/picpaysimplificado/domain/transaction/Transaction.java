package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="tbl_transactions")
@Table(name="tbl_transactions")
@Getter
@Setter
@AllArgsConstructor // construtor para receber todos os parametros da classe
@EqualsAndHashCode(of="cd_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_transaction")
    private long cdTransaction;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="cd_sender")
    private User sender;

    @ManyToOne
    @JoinColumn(name="cd_receiver")
    private User receiver;

    private LocalDateTime timeStamp;
}
