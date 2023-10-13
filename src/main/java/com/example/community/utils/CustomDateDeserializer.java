package com.example.community.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.minidev.json.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CustomDateDeserializer extends StdDeserializer<java.util.Date> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public CustomDateDeserializer() {
        this(null);
    }

    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public java.util.Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        String dateStr = jsonparser.getText();
        try {
            return dateFormat.parse(dateStr);
        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr);
        }
    }
}