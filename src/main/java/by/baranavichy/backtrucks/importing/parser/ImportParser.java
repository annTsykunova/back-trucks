package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by Vanya on 28.04.2019.
 */
public abstract class ImportParser<I> {

    private final CSVFormat format;

    public ImportParser(Class<? extends Enum<?>> columnClass) {
        this.format = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withHeader(columnClass)
                .withDelimiter(';')
                .withRecordSeparator("\n")
                .withFirstRecordAsHeader()
                .withIgnoreEmptyLines()
                .withIgnoreHeaderCase()
                .withIgnoreSurroundingSpaces();
    }

    public ImportParser(CSVFormat format) {
        this.format = format;
    }

    public Collection<I> parse(MultipartFile file) throws IOException {
        List<CSVRecord> records = this.format
                .parse(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))
                .getRecords();
        return records.stream()
                .map(this::toTo)
                .collect(Collectors.toList());
    }

    private I toTo(CSVRecord record) {
        I importTO = getNewImportTO().get();
        getGettersAndSetters().forEach(getterSetterPair -> {
            convertProperty(importTO, record, getterSetterPair);
        });
        return importTO;
    }

    private <P> void convertProperty(I to, CSVRecord importTo, GetterSetterPair<I, CSVRecord, P> getterSetterPair) {
        Function<CSVRecord, P> getter = getterSetterPair.getGetter();
        P property = getter.apply(importTo);

        BiConsumer<I, P> setter = getterSetterPair.getSetter();
        setter.accept(to, property);
    }

    protected abstract Collection<GetterSetterPair<I, CSVRecord, ?>> getGettersAndSetters();

    protected abstract Supplier<I> getNewImportTO();

}
