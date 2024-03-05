package com.example.Criptografia.controllers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Segredo {
    @PostMapping("/segredo")
    public String getSegredo(@RequestBody String RequestBody) {
        // Aqui você pode processar os dados recebidos no corpo da solicitação

        int segredo = Integer.parseInt(RequestBody);

        // Aqui faz a requisição das chaves públicas (inteiro e primo)
        Requisicao minhaRequisicao = new Requisicao();
        String chavesPublicas = minhaRequisicao.req();
        System.out.println(chavesPublicas);

        Alpha alpha = new Alpha();
        String teste = Integer.toString(alpha.getAlpha(chavesPublicas, segredo));

        ExportReq sendAlpha = new ExportReq();
        sendAlpha.req(teste);

        return "Deu certo <3";
    }
}