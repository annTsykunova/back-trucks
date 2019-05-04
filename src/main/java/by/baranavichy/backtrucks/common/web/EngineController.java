package by.baranavichy.backtrucks.common.web;

import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.service.EngineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Vanya on 04.05.2019.
 */
@Controller
@RequestMapping("/engines")
@ResponseBody
public class EngineController {

    private final EngineService engineService;


    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @GetMapping(produces = {"application/json"})
    public Collection<EngineTO> getEngines() {
        return engineService.getAll();
    }

}
