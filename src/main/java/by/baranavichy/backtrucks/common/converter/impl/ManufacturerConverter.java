package by.baranavichy.backtrucks.common.converter.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
public class ManufacturerConverter implements EntityTOConverter<Manufacturer, ManufacturerTO> {

    @Override
    public Manufacturer convertToEntity(ManufacturerTO to) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(to.getName());
        return manufacturer;
    }

    @Override
    public ManufacturerTO convertToTO(Manufacturer entity) {
        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setName(entity.getName());
        return manufacturerTO;
    }
}
