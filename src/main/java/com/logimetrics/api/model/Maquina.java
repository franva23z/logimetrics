package com.logimetrics.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "maquinas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    @Column(name = "custo_manutencao")
    private double custoManutencao;
    
    @Enumerated(EnumType.STRING)
    private StatusMaquina status;
    
    @Column(name = "custo_por_km")
    private double custoPorKm;

    
    public Maquina(String nome, double custoManutencao, StatusMaquina status, double custoPorKm) {
        this.nome = nome;
        this.custoManutencao = custoManutencao;
        this.status = status;
        this.custoPorKm = custoPorKm;
    }
}