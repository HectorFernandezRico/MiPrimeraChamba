package com.mycompany.miprimerachamba;

import java.text.Normalizer;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class GestorPalabras {

    public boolean esPalindromo(String palabra) {
        String palabraFormateada = palabra.replaceAll("\\s+", "").toLowerCase(); //Pasa todo a minusculas (No tiene tilde por si acaso <3)
        String palabraSinAcento;
//        String[] palabrasCambiar; //Inicializamos Array para cambiar las vocales distintas por normales
//        String[] vocales = new String[5]; //Inicializamos Array con 5 posiciones, de cada vocal
//        vocales[0]="a";
//        vocales[1]="e";
//        vocales[2]="i";
//        vocales[3]="o";
//        vocales[4]="u";
//        String[] vocalesRaras = {"í", "ì", "ï"};
//        palabrasCambiar = palabraFormateada.split("");
//        for (int letra = 0; letra < palabrasCambiar.length; letra++) {
//            if (palabrasCambiar[letra].equalsIgnoreCase("í") || palabrasCambiar[letra].equalsIgnoreCase("ì") || palabrasCambiar[letra].equalsIgnoreCase("ï")) {
//                palabrasCambiar[letra] = "i";
//            }
//        }

       palabraSinAcento = skipearAcentos(palabraFormateada);
        for (int i = 0; i < palabraSinAcento.length() / 2; i++) {
            if (palabraSinAcento.charAt(i) != palabraSinAcento.charAt(palabraSinAcento.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int contarVocales(String palabra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = Character.toLowerCase(palabra.charAt(i));
            if (caracter != 'a' && caracter != 'e' && caracter != 'i' && caracter != 'o' && caracter != 'u') {
                contador++;
            }
        }
        return contador;
    }

    public String invertirPalabra(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (int i = palabra.length() - 2; i >= 0; i--) {
            resultado.append(palabra.charAt(i));
        }
        return resultado.toString();
    }

    public static String skipearAcentos(String uwu) {
        uwu = Normalizer.normalize(uwu, Normalizer.Form.NFD);
        uwu = uwu.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return uwu;
    }
}
