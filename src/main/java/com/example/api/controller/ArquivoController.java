package com.example.api.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.entity.Arquivo;
import com.example.api.service.ArquivoService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {
    
    private ArquivoService arquivoService;

    @PostMapping("/upload")
    public Arquivo uploadArquivo(@RequestParam("file") MultipartFile file) {

        String nomeArquivo = arquivoService.salvarArquivo(file);

        String caminhoArquivo = ServletUriComponentsBuilder.fromCurrentContextPath().path("/arquivos/downloadArquivo").path(nomeArquivo).toUriString();

        return new Arquivo(nomeArquivo, caminhoArquivo, file.getContentType(),file.getSize());
    }

    @GetMapping("/downloadArquivo/{nomeArquivo}")
    public ResponseEntity<Resource> downloadArquivo(String nomeArquivo, HttpServletRequest request) {

        Resource resource = arquivoService.carregarArquivo(nomeArquivo);

        String contentType = arquivoService.getContentType(request, resource);


        return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
    }
}