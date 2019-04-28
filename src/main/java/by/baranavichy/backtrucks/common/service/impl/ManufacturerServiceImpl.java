package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.ManufacturerConverter;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.common.service.ManufacturerService;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Vanya on 27.04.2019.
 */

@Service
public class ManufacturerServiceImpl extends EntityServiceImpl<Manufacturer, ManufacturerTO, Long> implements ManufacturerService {

    public ManufacturerServiceImpl(ManufacturerConverter manufacturerConverter,
                                   ManufacturerRepository manufacturerRepository) {
        super(manufacturerConverter, manufacturerRepository);
    }
}
