package io.everyonecodes.singapore_reconstruction;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@ConfigurationPropertiesBinding
public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        if (source == null) {
            return null;
        }
        return LocalDate.parse(source, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
