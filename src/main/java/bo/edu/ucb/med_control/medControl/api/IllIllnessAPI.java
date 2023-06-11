package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.dto.IllIllnessDTO;
import bo.edu.ucb.med_control.medControl.bl.IllIllnessBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/illness")
public class IllIllnessAPI {
    private IllIllnessBL illIllnessBL;

    @Autowired
    public IllIllnessAPI(IllIllnessBL illIllnessBL) {
        this.illIllnessBL = illIllnessBL;
    }

    @GetMapping
    public List<IllIllnessDTO> getAllIllnesses() {
        System.out.println("getAllIllnesses");
        System.out.println(illIllnessBL.findAll());
        return illIllnessBL.findAll();
    }

    @GetMapping(path = "/{id}")
    public IllIllnessDTO findIllnessById(@PathVariable Integer id) {
        return illIllnessBL.findById(id);
    }
}
