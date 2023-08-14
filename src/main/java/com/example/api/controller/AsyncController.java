package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.RelatorioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/asyncs")
@AllArgsConstructor

public class AsyncController {

    private RelatorioService relatorioService;
    
    @GetMapping
    public ResponseEntity<String> gerarRelatorio() throws InterruptedException {
        relatorioService.gerarRelatorio();
        return ResponseEntity.ok("Relatório iniciado com sucesso");
    }
}
