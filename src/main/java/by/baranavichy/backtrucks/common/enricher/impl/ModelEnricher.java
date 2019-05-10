//package by.baranavichy.backtrucks.common.enricher.impl;
//
//import by.baranavichy.backtrucks.common.enricher.EntityEnricher;
//import by.baranavichy.backtrucks.common.model.to.ModelTO;
//import by.baranavichy.backtrucks.persistence.model.Engine;
//import by.baranavichy.backtrucks.persistence.model.Manufacturer;
//import by.baranavichy.backtrucks.persistence.model.Model;
//import by.baranavichy.backtrucks.persistence.repository.EngineRepository;
//import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//import java.util.stream.Stream;
//
///**
// * Created by Vanya on 10.05.2019.
// */
//
//@Component
//@RequiredArgsConstructor
//public class ModelEnricher implements EntityEnricher<Model> {
//
//    private final ManufacturerRepository manufacturerRepository;
//    private final EngineRepository engineRepository;
//
//
//    @Override
//    public Model enrich(Model entityToEnrich) {
//        Optional<Manufacturer> maybeManufacturer =
//                manufacturerRepository.findByNameIgnoreCase(entityToEnrich.getManufacturer().getName());
//
//        maybeManufacturer.ifPresent(entityToEnrich::setManufacturer);
//
//        Stream<Optional<Engine>> maybeEngines =
//                entityToEnrich.getEnginesCopy().stream()
//                        .map(engineTO -> engineRepository.findByNameIgnoreCase(engineTO.getName()));
//        maybeEngines
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .forEach(entityToEnrich::addEngine);
//
//        return model;
//    }
//}
