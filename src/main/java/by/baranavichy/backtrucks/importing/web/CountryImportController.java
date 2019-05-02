package by.baranavichy.backtrucks.importing.web;

import by.baranavichy.backtrucks.importing.service.CountryImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vanya on 28.04.2019.
 */

@Controller
@RequestMapping("/import/countries")
public class CountryImportController {

    private final CountryImportService countryImportService;

    public CountryImportController(CountryImportService countryImportService) {
        this.countryImportService = countryImportService;
    }

    @PostMapping
    public ResponseEntity<String> importData(@RequestParam("file") MultipartFile file, HttpServletRequest httpRequest) {
        countryImportService.importData(file);
        return ResponseEntity.ok().build();
    }

}
