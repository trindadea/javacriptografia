package com.example.Criptografia.controllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Requisicao {

    public String req() {
        try {
            // URL para a qual você deseja fazer a requisição GET
            URL url = new URL("http://15.229.56.199/chaves");

            // Abre uma conexão HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Define o método da requisição como GET
            connection.setRequestMethod("GET");

            // Acrescenta a chave da API ao header da requisição
            connection.setRequestProperty("apikey", "123456");

            // Lê a resposta do servidor
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Se a resposta for bem-sucedida (código 200), leia e imprima a resposta
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Imprime a resposta
                return response.toString();
            } else {
                // Se a resposta não for bem-sucedida, leia e imprima a mensagem de erro
                BufferedReader errorIn = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String errorInputLine;
                StringBuffer errorResponse = new StringBuffer();

                while ((errorInputLine = errorIn.readLine()) != null) {
                    errorResponse.append(errorInputLine);
                }
                errorIn.close();

                // Imprime a mensagem de erro
                return  "Erro: " + errorResponse.toString();
            }

        } catch (IOException e) {
            // Retorna uma mensagem de erro em caso de exceção de E/S
            e.printStackTrace();
            return "Erro ao fazer a requisição: " + e.getMessage();
        }
    }
}
