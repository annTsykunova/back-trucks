package by.baranavichy.backtrucks.common.web;

import by.baranavichy.backtrucks.common.model.to.DetailTO;
import by.baranavichy.backtrucks.common.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Vanya on 10.05.2019.
 */

@Controller
@RequestMapping("/details")
@ResponseBody
@RequiredArgsConstructor
public class DetailController {

    private final DetailService detailService;

    @GetMapping(produces = {"application/json"})
    public Collection<DetailTO> getAll() {
        return detailService.getAll();
    }

}
