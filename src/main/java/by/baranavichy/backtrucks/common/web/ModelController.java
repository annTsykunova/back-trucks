package by.baranavichy.backtrucks.common.web;

import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.common.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Collection;

/**
 * Created by Vanya on 05.05.2019.
 */

@Controller
@RequestMapping("/models")
@ResponseBody
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping(produces = {"application/json"})
    public Collection<ModelTO> getModels() {
        return modelService.getAll();
    }

    @GetMapping
    public ModelTO getOne(@PathParam("id") Long id) {
        return modelService.getOne(id);
    }

}
