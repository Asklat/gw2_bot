/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asklat.gw2_bot;

import com.google.gson.Gson;
import com.asklat.gw2_bot.Objects.Item;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author algam
 */
public class ConnectionClass {

    public static Item[] getMateriales(String idDiscord) throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL("http://127.0.0.1/api/mejorasclan?idDc=" + idDiscord);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        Item[] li = null;
        if (!resultado.toString().contains("\"error\":1")) {
            li = new Gson().fromJson(resultado.toString(), Item[].class);
        }
        return li;
    }

    public static String saveGuild(String idDiscord, String apiKey) throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL("http://127.0.0.1/api/setApikey?idDc=" + idDiscord + "&apiKey=" + apiKey);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        String a = "Se ha guardado correctamente!";
        if (resultado.toString().contains("\"error\":1")) {
            a = "Hubo un error a la hora de guardar la api key :(";
        } else {
            if (a.contains("\"error\":2")) {
                a = "Este server ya gestiona un clan.";
            }
        }
        // Regresar resultado, pero como cadena, no como StringBuilder
        return a;
    }
}
