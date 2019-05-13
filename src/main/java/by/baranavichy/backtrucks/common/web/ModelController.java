package by.baranavichy.backtrucks.common.web;

import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.common.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ModelTO getOne(@PathVariable Long id) {
        return modelService.getOne(id);
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"})
    public ModelTO updateOne(@PathVariable Long id, @RequestBody ModelTO modelTO) {
        return modelService.save(modelTO);
    }

}
