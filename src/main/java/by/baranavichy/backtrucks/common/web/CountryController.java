package by.baranavichy.backtrucks.common.web;

import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.common.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Vanya on 02.05.2019.
 */

@Controller
@RequestMapping("/countries")
@ResponseBody
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(produces = {"application/json"})
    public Collection<CountryTO> getCountries() {
        return countryService.getAll();
    }

}
