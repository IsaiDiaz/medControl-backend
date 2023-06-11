package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.AlgSeverityBL;
import bo.edu.ucb.med_control.medControl.dto.AlgSeverityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/severity")
public class AlgSeverityAPI {

    private AlgSeverityBL algSeverityBL;

    @Autowired
    public AlgSeverityAPI(AlgSeverityBL algSeverityBL) {
        this.algSeverityBL = algSeverityBL;
    }

    @GetMapping
    public List<AlgSeverityDTO> getAllSeverities() {
        System.out.println("getAllSeverities");
        System.out.println(algSeverityBL.findAll());
        return algSeverityBL.findAll();
    }

    @GetMapping(path = "/{id}")
    public AlgSeverityDTO findSeverityById(@PathVariable Integer id) {
        return algSeverityBL.findById(id);
    }

}
