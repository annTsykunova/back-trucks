package by.baranavichy.backtrucks.importing.web;

import by.baranavichy.backtrucks.importing.service.EngineImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 29.04.2019.
 */

@Controller
@RequestMapping("/import/engines")
public class EngineImportController {

    private final EngineImportService engineImportService;


    public EngineImportController(EngineImportService engineImportService) {
        this.engineImportService = engineImportService;
    }

    @PostMapping
    public ResponseEntity importData(@RequestParam("file") MultipartFile file) {
        engineImportService.importData(file);
        return ResponseEntity.ok().build();
    }

}
