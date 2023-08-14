package com.example.api.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class RelatorioService {

    NotificationService notificationService;
    
    @Async
    public void gerarRelatorio() throws InterruptedException {
        log.info("Tarefa iniciada");
        Thread.sleep(10000);
        
        notificationService.publicar("Tarefa finalizada");
    }
}
