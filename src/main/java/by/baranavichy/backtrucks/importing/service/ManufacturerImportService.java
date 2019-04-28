package by.baranavichy.backtrucks.importing.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 27.04.2019.
 */
public interface ManufacturerImportService {

    void importBrands(MultipartFile brandFile);

}
