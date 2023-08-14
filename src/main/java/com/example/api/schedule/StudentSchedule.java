package com.example.api.schedule;

// import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StudentSchedule {
    
    // @Scheduled(fixedDelay = 3000)
    // @Scheduled(cron = "1 2 3 4 5 6")
    public void executarTarefa() {
        log.info("Tarefa executada");
    }
}
