package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.DetailConverter;
import by.baranavichy.backtrucks.common.enricher.impl.DetailFetcher;
import by.baranavichy.backtrucks.common.model.to.DetailTO;
import by.baranavichy.backtrucks.common.service.DetailService;
import by.baranavichy.backtrucks.common.service.EntityServiceImpl;
import by.baranavichy.backtrucks.persistence.model.Detail;
import by.baranavichy.backtrucks.persistence.repository.DetailRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Vanya on 10.05.2019.
 */

@Service
public class DetailServiceImpl
        extends EntityServiceImpl<Detail, DetailTO, Long>
        implements DetailService {

    private final DetailRepository detailRepository;

    public DetailServiceImpl(DetailConverter detailConverter, DetailRepository detailRepository,
                             DetailFetcher detailEnricher) {
        super(detailConverter, detailRepository, detailEnricher);
        this.detailRepository = detailRepository;
    }

    @Override
    protected Optional<Long> getExistingEntityId(Detail entityToSave) {
        return detailRepository.findIdByName(entityToSave.getName());
    }
}
