package com.example.api.service;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

import jakarta.annotation.PreDestroy;

@Service
public class NotificationService {
    
    private final SocketIONamespace namespace;
    private final SocketIOServer server;

    public void publicar(String mensagem) {
        namespace.getBroadcastOperations().sendEvent("notificacao", mensagem);
    }

    public NotificationService(SocketIOServer server) {
        this.server = server;

        this.namespace = server.addNamespace("/ws-listener");

        this.server.start();

    }

    @PreDestroy
    private void stopSocketIO() {
        this.server.stop();
    }
}
