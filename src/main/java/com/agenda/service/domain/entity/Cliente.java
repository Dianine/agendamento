package com.agenda.service.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome do Clinete é obrigatório")
    private String nome;
    @NotBlank(message = "Sobrenome do Clinete é obrigatório")
    private String sobrenome;
    private String email;
    @NotBlank(message = "CPF do Clinete é obrigatório")
    private String cpf;

}
