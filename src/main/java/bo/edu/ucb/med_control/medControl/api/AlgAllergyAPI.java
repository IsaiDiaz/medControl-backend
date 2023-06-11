package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.AlgAllergyBL;
import bo.edu.ucb.med_control.medControl.dto.AlgAllergyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/allergy")
public class AlgAllergyAPI {
    private AlgAllergyBL algAllergyBL;

    @Autowired
    public AlgAllergyAPI(AlgAllergyBL algAllergyBL) {
        this.algAllergyBL = algAllergyBL;
    }

    @GetMapping
    public List<AlgAllergyDTO> getAllAllergies() {
        System.out.println("getAllAllergies");
        System.out.println(algAllergyBL.findAll());
        return algAllergyBL.findAll();
    }

    @GetMapping(path = "/{id}")
    public AlgAllergyDTO findAllergyById(@PathVariable Integer id) {
        return algAllergyBL.findById(id);
    }
}

