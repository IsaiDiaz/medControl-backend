package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.MdhMedicalHistoryTypeBL;
import bo.edu.ucb.med_control.medControl.dto.MdhMedicalHistoryTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/medicalHistoryType")
public class MdhMedicalHistoryTypeAPI {
    private MdhMedicalHistoryTypeBL mdhMedicalHistoryTypeBL;

    @Autowired
    public MdhMedicalHistoryTypeAPI(MdhMedicalHistoryTypeBL mdhMedicalHistoryTypeBL) {
        this.mdhMedicalHistoryTypeBL = mdhMedicalHistoryTypeBL;
    }

    @GetMapping
    public List<MdhMedicalHistoryTypeDTO> getAllMedicalHistoryTypes() {
        System.out.println("getAllMedicalHistoryTypes");
        System.out.println(mdhMedicalHistoryTypeBL.findAll());
        return mdhMedicalHistoryTypeBL.findAll();
    }

    @GetMapping(path = "/{id}")
    public MdhMedicalHistoryTypeDTO findMedicalHistoryTypeById(@PathVariable Integer id) {
        return mdhMedicalHistoryTypeBL.findById(id);
    }
}
