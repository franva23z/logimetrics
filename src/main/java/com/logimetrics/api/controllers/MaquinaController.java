package com.logimetrics.api.controllers;

import com.logimetrics.api.model.CalculoRota;
import com.logimetrics.api.model.Maquina;
import com.logimetrics.api.model.StatusMaquina;
import com.logimetrics.api.service.MaquinaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maquinas")
@CrossOrigin(origins = "*") 
public class MaquinaController {

    private final MaquinaService service;

    public MaquinaController(MaquinaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Maquina> listar() {
        return service.listarTodas();
    }

    @GetMapping("/ativas")
    public List<Maquina> listarAtivas() {
        return service.filtrarPorStatus(StatusMaquina.ATIVA);
    }

    @GetMapping("/manutencao")
    public List<Maquina> listarManutencao() {
        return service.filtrarPorStatus(StatusMaquina.MANUTENCAO);
    }

    @PostMapping("/calcular-viagem")
    public String calcularViagem(@RequestBody CalculoRota rota) {
        double total = service.calcularGastoViagem(rota);
        return String.format("R$ %.2f", total);
    }
    
@PostMapping
public Maquina salvar(@RequestBody Maquina maquina) {
    return service.salvar(maquina);
}

@PatchMapping("/{id}/status")
public Maquina atualizarStatus(@PathVariable Long id, @RequestParam StatusMaquina novoStatus) {
    Maquina maquina = service.buscarPorId(id);
    maquina.setStatus(novoStatus);
    return service.salvar(maquina);
}

@GetMapping("/inativas")
public List<Maquina> listarInativas() {
    return service.filtrarPorStatus(StatusMaquina.INATIVA);
}

}