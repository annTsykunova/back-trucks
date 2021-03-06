package by.baranavichy.backtrucks.importing.web;

import by.baranavichy.backtrucks.importing.service.ManufacturerImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 27.04.2019.
 */

@Controller
@RequestMapping("/import/manufacturers")
@RequiredArgsConstructor
public class ManufacturerImportController {

    private final ManufacturerImportService manufacturerImportService;

    @PostMapping
    public ResponseEntity importData(@RequestParam("file") MultipartFile file) {
        manufacturerImportService.importData(file);
        return ResponseEntity.ok().build();
    }

}
