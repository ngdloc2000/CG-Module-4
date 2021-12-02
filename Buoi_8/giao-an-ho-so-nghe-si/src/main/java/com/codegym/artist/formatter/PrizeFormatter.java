package com.codegym.artist.formatter;

import com.codegym.artist.model.Prize;
import com.codegym.artist.service.prize.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class PrizeFormatter implements Formatter<Prize> {
    private IPrizeService prizeService;

    @Autowired
    public PrizeFormatter(IPrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @Override
    public Prize parse(String text, Locale locale) throws ParseException {
        Optional<Prize> prizeOptional = prizeService.findById(Long.parseLong(text));
        return prizeOptional.orElse(null);
    }

    @Override
    public String print(Prize object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
