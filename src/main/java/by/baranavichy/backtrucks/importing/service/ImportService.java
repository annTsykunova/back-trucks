package by.baranavichy.backtrucks.importing.service;

import by.baranavichy.backtrucks.importing.model.ImportTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 28.04.2019.
 */
public interface ImportService<T, I extends ImportTO> {


    void importData(MultipartFile brandFile);

}
