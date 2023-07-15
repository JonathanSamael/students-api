package com.example.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo {
    private String nomeArquivo;
    private String linkDownload;
    private String extensaoArquivo;
    private long size;
}
