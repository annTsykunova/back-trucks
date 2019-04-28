package by.baranavichy.backtrucks.importing.web;

import by.baranavichy.backtrucks.importing.service.CountryImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 28.04.2019.
 */

@Controller
@RequestMapping("/import/countries")
@RequiredArgsConstructor
public class CountryImportController {

    private final CountryImportService countryImportService;

    @PostMapping
    public ResponseEntity importBrands(@RequestParam("file") MultipartFile file) {
        countryImportService.importData(file);
        return ResponseEntity.ok().build();
    }

}
