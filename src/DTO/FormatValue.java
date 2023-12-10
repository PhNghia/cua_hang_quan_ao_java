/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author BomPC
 */
public class FormatValue {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter dateTimeFormatterSQL = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
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

    public static String formatCurrency(long value) {
        return decimalFormatter.format(value) + " VNĐ";
    }

    public static LocalDateTime convertStringtoLocalDateTime(String value) {
        // use with String pattern dd--mm-yyyy
        String[] split = value.substring(0, value.indexOf("T")).split("-");
        LocalDate date = LocalDate.parse(String.format("%s-%s-%s", split[2], split[1], split[0]));
        value = date.toString() + value.substring(value.indexOf("T"), value.length());
        LocalDateTime datetime = LocalDateTime.parse(value);
        return datetime;
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        // Date in = new Date();
        // LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(),
        // ZoneId.systemDefault());
        Date out = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return out;
    }

    public static LocalDateTime converDateToLocalDateTime(Date dateToConvert) {
        return new java.sql.Timestamp(
                dateToConvert.getTime()).toLocalDateTime();
    }
}
