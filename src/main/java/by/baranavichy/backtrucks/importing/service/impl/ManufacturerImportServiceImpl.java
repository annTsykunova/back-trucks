package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.service.ManufacturerService;
import by.baranavichy.backtrucks.importing.converter.ManufacturerImportConverter;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import by.baranavichy.backtrucks.importing.parser.ManufacturerParser;
import by.baranavichy.backtrucks.importing.service.ManufacturerImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Vanya on 27.04.2019.
 */

@Service
@RequiredArgsConstructor
public class ManufacturerImportServiceImpl implements ManufacturerImportService {

    private final ManufacturerService manufacturerService;
    private final ManufacturerParser manufacturerParser;
    private final ManufacturerImportConverter manufacturerImportConverter;

    @Override
    public void importBrands(MultipartFile file) {
        try {
            Collection<ManufacturerImportTO> manufacturerImportTOS = manufacturerParser.parse(file);
            manufacturerImportTOS.stream()
                    .map(manufacturerImportConverter::toTo)
                    .forEach(manufacturerService::save);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
