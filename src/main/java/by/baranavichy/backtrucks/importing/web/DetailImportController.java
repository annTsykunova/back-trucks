package by.baranavichy.backtrucks.importing.web;

import by.baranavichy.backtrucks.importing.service.DetailImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 10.05.2019.
 */

@Controller
@RequestMapping("/import/details")
@RequiredArgsConstructor
public class DetailImportController {

    private final DetailImportService detailImportService;

    @PostMapping
    public ResponseEntity<String> importData(@RequestParam("file") MultipartFile file) {
        detailImportService.importData(file);
        return ResponseEntity.ok().build();
    }

}
