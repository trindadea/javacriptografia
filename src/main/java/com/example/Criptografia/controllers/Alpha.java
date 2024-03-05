package com.example.Criptografia.controllers;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Alpha {
    public int getAlpha(String jsonChaves, int segredo) {
        // Criar um objeto Gson
        Gson gson = new Gson();

        // Fazer o parsing do JSON para um objeto JsonObject
        JsonObject jsonObject = gson.fromJson(jsonChaves, JsonObject.class);

        // Extrair os valores
        int primo = jsonObject.get("primo").getAsInt();
        int inteiro = jsonObject.get("inteiro").getAsInt();

        // Imprimir os valores
        System.out.println("Primo: " + primo);
        System.out.println("Inteiro: " + inteiro);

        int alpha = (int) (Math.pow(inteiro, segredo) % primo);
        System.out.println("Alpha: " + alpha);
        return alpha;
    }
}
