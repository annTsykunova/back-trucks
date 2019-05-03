package by.baranavichy.backtrucks.importing.parser;

import by.baranavichy.backtrucks.common.model.GetterSetterPair;
import by.baranavichy.backtrucks.importing.exception.ValidationException;
import by.baranavichy.backtrucks.importing.model.column.RequirableColumn;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Vanya on 28.04.2019.
 */
public abstract class ImportParser<I, C extends Enum<?> & RequirableColumn> {

    private final CSVFormat format;
    private final Set<C> headerColumns;

    public ImportParser(C[] headerColumns) {
        Class<C> headerClass = (Class<C>) headerColumns[0].getClass();
        this.format = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withHeader(headerClass)
                .withDelimiter(';')
                .withRecordSeparator("\n")
                .withFirstRecordAsHeader()
                .withIgnoreEmptyLines()
                .withIgnoreHeaderCase()
                .withIgnoreSurroundingSpaces();
        this.headerColumns = Set.of(headerColumns);
    }

    public Stream<I> parse(MultipartFile file) {
        CSVParser parser;
        try {
            parser = this.format.parse(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        validateRequiredColumns(parser);

        return StreamSupport.stream(parser.spliterator(), true)
                .map(record -> {
                    try {
                        return Optional.of(toTo(record));
                    } catch (Exception e) {
                        return Optional.<I>empty();
                    }
                })
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    private I toTo(CSVRecord record) {
        I importTO = getNewImportTO().get();
        getGettersAndSetters().forEach(getterSetterPair -> {
            convertProperty(importTO, record, getterSetterPair);
        });
        return importTO;
    }

    private void validateRequiredColumns(CSVParser parser) {
        Set<String> normalizedRequiredColumns = headerColumns.stream()
                .filter(RequirableColumn::isRequired)
                .map(column -> column.name())
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        Set<String> normalizedPresentColumns = parser.getHeaderMap().keySet().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        Set<String> absentRequiredColumns = normalizedRequiredColumns;
        absentRequiredColumns.removeAll(normalizedPresentColumns);
        if (!absentRequiredColumns.isEmpty()) {
            throw new ValidationException(String.format("Required columns %s are not present", absentRequiredColumns));
        }
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
