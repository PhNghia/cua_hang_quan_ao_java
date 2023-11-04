/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author BomPC
 */
public class FormatValue {
    
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DecimalFormat decimalFormatter = new DecimalFormat("###,###,###");
    
    public static String formatDateTime(String value) {
        LocalDateTime dateTime = LocalDateTime.parse(value);
        String formattedDateTime = dateTime.format(dateTimeFormatter);
        return formattedDateTime;
    }
    
    public static String formatDateTime(LocalDateTime dateTime) {
        String formattedDateTime = dateTime.format(dateTimeFormatter);
        return formattedDateTime;
    }
    
    public static String formatCurrency (long value) {
        return decimalFormatter.format(value) + " VNĐ";
    }
}
