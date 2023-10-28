/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author BomPC
 */
public class FormatDateTime {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static String formatDateTime(String value) {
        LocalDateTime dateTime = LocalDateTime.parse(value);
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }
    
    public static String formatDateTime(LocalDateTime dateTime) {
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }
}
