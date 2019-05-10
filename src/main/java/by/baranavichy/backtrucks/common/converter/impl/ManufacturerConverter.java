package by.baranavichy.backtrucks.common.converter.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
@RequiredArgsConstructor
public class ManufacturerConverter implements EntityTOConverter<Manufacturer, ManufacturerTO> {

    private final CountryConverter countryConverter;

    @Override
    public Manufacturer convertToEntity(ManufacturerTO to) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(to.getName());
        if (to.getCountry() != null) {
            manufacturer.setCountry(countryConverter.convertToEntity(to.getCountry()));
        }
        return manufacturer;
    }

    @Override
    public ManufacturerTO convertToTO(Manufacturer entity) {
        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setId(entity.getId());
        manufacturerTO.setName(entity.getName());
        if (entity.getCountry() != null) {
            manufacturerTO.setCountry(countryConverter.convertToTO(entity.getCountry()));
        }
        return manufacturerTO;
    }
}
