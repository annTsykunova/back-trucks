package by.baranavichy.backtrucks.importing.web;

import by.baranavichy.backtrucks.importing.service.ModelImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 05.05.2019.
 */

@Controller
@RequestMapping("/import/models")
@RequiredArgsConstructor
public class ModelImportController {

    private final ModelImportService modelImportService;

    @PostMapping
    public ResponseEntity importData(@RequestParam("file") MultipartFile file) {
        modelImportService.importData(file);
        return ResponseEntity.ok().build();
    }

}
