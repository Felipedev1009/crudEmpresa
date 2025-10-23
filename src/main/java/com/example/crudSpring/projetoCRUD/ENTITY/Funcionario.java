package com.example.crudSpring.projetoCRUD.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@NoArgsConstructor
@Getter
@Setter

public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false, unique=true)
    private Long id_codigo;

    @Column(name = "nome", nullable = false, length=100)
    private String nome;

    @Column(name = "cargo", nullable = false, length=20, unique=true)
    private String cargo;

    @Column(name = "salario", nullable = false, length=100)
    private double salario;

    @ManyToOne
    @JoinColumn (name = "empresaID", nullable = false)
    private Empresa identificadorEmpresa;

    public Funcionario(Long id_codigo, String nome, String cargo, double salario, Empresa identificadorEmpresa) {
        this.id_codigo = id_codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.identificadorEmpresa = identificadorEmpresa;
    }


}




    

