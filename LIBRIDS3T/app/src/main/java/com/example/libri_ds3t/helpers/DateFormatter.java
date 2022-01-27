package com.example.libri_ds3t.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {
    private String format = "dd-MM-yyyy HH:mm:ss";
    private String locale = "pt-BR";
    SimpleDateFormat sdf = null;

    public DateFormatter() {
        this.sdf = new SimpleDateFormat(this.format, new Locale(this.locale));
    }

    public String getDate() {
        return sdf.format(new Date());
    }
}
