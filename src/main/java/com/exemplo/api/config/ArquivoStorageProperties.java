package com.exemplo.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ArquivoStorageProperties {
    
    @Value("${arquivo.uploadDir}")
    private String uploadDir;    
    
}
