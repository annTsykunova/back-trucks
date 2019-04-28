package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import by.baranavichy.backtrucks.importing.model.column.ManufacturerColumn;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
public class ManufacturerParser {

    private final CSVFormat format;

    public ManufacturerParser() {
        format = CSVFormat.EXCEL
                .withFirstRecordAsHeader()
                .withHeader(ManufacturerColumn.class)
                .withFirstRecordAsHeader()
                .withIgnoreEmptyLines()
                .withIgnoreHeaderCase()
                .withIgnoreSurroundingSpaces();
    }

    public Collection<ManufacturerImportTO> parse(MultipartFile file) throws IOException {
        List<CSVRecord> records = format.parse(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))
                .getRecords();
        return records.stream()
                .map(this::toTo)
                .collect(Collectors.toList());

    }

    private ManufacturerImportTO toTo(CSVRecord record) {
        ManufacturerImportTO brandImport = new ManufacturerImportTO();
        brandImport.setName(record.get(ManufacturerColumn.NAME));
        return brandImport;
    }

}
