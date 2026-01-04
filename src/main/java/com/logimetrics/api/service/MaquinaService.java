package com.logimetrics.api.service;

import com.logimetrics.api.model.CalculoRota;
import com.logimetrics.api.model.Maquina;
import com.logimetrics.api.model.StatusMaquina;
import com.logimetrics.api.repository.MaquinaRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository repository; 

    public List<Maquina> listarTodas() {
        return repository.findAll(); 
    }

    public List<Maquina> filtrarPorStatus(StatusMaquina status) {
        return repository.findByStatus(status);
    }

    public double calcularCustoTotal() {
        return repository.findAll().stream()
                .mapToDouble(Maquina::getCustoManutencao)
                .sum();
    }

    public double calcularGastoViagem(CalculoRota rota) {
        
        Maquina maquina = repository.findById(rota.getMaquinaId())
                .orElseThrow(() -> new RuntimeException("Máquina não encontrada no banco!"));

        return rota.getDistanciaKm() * maquina.getCustoPorKm();
    }
    
     public Maquina salvar(Maquina maquina) {
    return repository.save(maquina);
    }

    public Maquina buscarPorId(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Máquina não encontrada"));

    }
}