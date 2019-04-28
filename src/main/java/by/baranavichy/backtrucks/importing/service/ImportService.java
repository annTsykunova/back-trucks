package by.baranavichy.backtrucks.importing.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Vanya on 28.04.2019.
 */
public interface ImportService<T, I> {


    void importData(MultipartFile brandFile);

}
