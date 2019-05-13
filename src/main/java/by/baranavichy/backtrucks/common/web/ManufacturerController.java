package by.baranavichy.backtrucks.common.web;

import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.common.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created
 * by Vanya on 03.05.2019.
 */

@Controller
@RequestMapping("/manufacturers")
@ResponseBody
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping(produces = {"application/json"})
    public Collection<ManufacturerTO> getManufacturers() {
        return manufacturerService.getAll();
    }


    @GetMapping("/{id}")
    public ManufacturerTO getOne(@PathVariable Long id) {
        return manufacturerService.getOne(id);
    }

}
