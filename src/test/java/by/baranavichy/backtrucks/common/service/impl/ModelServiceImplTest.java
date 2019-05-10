package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.EngineConverter;
import by.baranavichy.backtrucks.common.converter.impl.ManufacturerConverter;
import by.baranavichy.backtrucks.common.converter.impl.ModelConverter;
import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.persistence.model.Engine;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.model.Model;
import by.baranavichy.backtrucks.persistence.repository.EngineRepository;
import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
import by.baranavichy.backtrucks.persistence.repository.ModelRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Vanya on 06.05.2019.
 */

@RunWith(MockitoJUnitRunner.class)
public class ModelServiceImplTest {

    @Mock
    private ModelRepository modelRepository;
    @Mock
    private ManufacturerRepository manufacturerRepository;
    @Mock
    private EngineRepository engineRepository;
    @Mock
    private ModelConverter modelConverter;
    @Mock
    private ManufacturerConverter manufacturerConverter;

    private EngineConverter engineConverter;

    @InjectMocks
    private ModelServiceImpl modelService;

    private ModelTO to;
    private Model entity;
    private Manufacturer manufacturer;
    private Engine engine;

    @BeforeClass
    public void setUpClass() {
        engineConverter = mock(EngineConverter.class);
    }

    @Before
    public void setUp() throws Exception {
        String modelName = "Sprinter";
        String manufacturerName = "Mercedes-Benz";
        LocalDate productionDateStartOld = LocalDate.of(2000, 1, 1);
        LocalDate productionDateStartNew = LocalDate.of(2001, 1, 1);
        LocalDate productionDateEnd = LocalDate.of(2005, 1, 1);
        String engineName = "m50b20";
        short engineDisplacement = 3000;

        to = new ModelTO();
        to.setName(modelName);
        to.setProductionDateStart(productionDateStartNew);
        to.setProductionDateEnd(productionDateEnd);
        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setName(manufacturerName);
        to.setManufacturer(manufacturerTO);
        EngineTO engineTO = new EngineTO();
        engineTO.setName(engineName);
        to.addEngine(engineTO);

        manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerName);

        engine = new Engine();
        engine.setName(engineName);
        engine.setManufacturer(manufacturer);
        engine.setDisplacement(engineDisplacement);

        entity = new Model();
        entity.setName(modelName);
        entity.setProductionDateStart(productionDateStartNew);
        entity.setProductionDateEnd(productionDateEnd);
        entity.setManufacturer(manufacturer);
        entity.addEngine(engine);

        when(modelConverter.convertToEntity(any(ModelTO.class)))
                .thenCallRealMethod();
        when(manufacturerConverter.convertToEntity(any(ManufacturerTO.class)))
                .thenCallRealMethod();
        when(engineConverter.convertToEntity(any(EngineTO.class)))
                .thenCallRealMethod();
        when(modelRepository.findByNameIgnoreCase(modelName))
                .thenReturn(Optional.of(entity));
        when(manufacturerRepository.findByNameIgnoreCase(manufacturerName))
                .thenReturn(Optional.ofNullable(manufacturer));
        when(engineRepository.findByNameIgnoreCase(engineName))
                .thenReturn(Optional.ofNullable(engine));
    }

    @Test
    public void getAll() {
    }

    @Test
    public void save() {
        try {
            ModelTO saved = modelService.save(to);
            System.out.println();
        } catch (Exception e) {
            System.out.println();
        }


    }

    @Test
    public void delete() {
    }

    @Test
    public void getExistingEntity() {
    }

    @Test
    public void convertToEntity() {
    }
}