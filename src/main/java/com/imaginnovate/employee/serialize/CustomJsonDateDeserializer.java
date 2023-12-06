package com.imaginnovate.employee.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public java.sql.Date deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException, JsonProcessingException {

        try {
            String date = jsonparser.getText();
            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");*/
            java.util.Date dt = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(date);
            return new java.sql.Date(dt.getTime());
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
