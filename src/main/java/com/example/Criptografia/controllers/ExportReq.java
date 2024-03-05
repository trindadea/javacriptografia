package com.example.Criptografia.controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ExportReq {

    public String req(String requestBody) {
        try {
            // URL para a qual você deseja fazer a requisição POST
            URL url = new URL("http://localhost:8080/export");

            // Abre uma conexão HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Define o método da requisição como POST
            connection.setRequestMethod("POST");

            // Habilita envio de dados
            connection.setDoOutput(true);

            // Escreve os dados do corpo da requisição
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
                wr.write(requestBodyBytes);
            }

            // Lê a resposta da requisição
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }

        } catch (IOException e) {
            // Retorna uma mensagem de erro em caso de exceção de E/S
            e.printStackTrace();
            return "Erro ao fazer a requisição: " + e.getMessage();
        }
    }
}
