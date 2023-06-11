package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.MdhKinshipBL;
import bo.edu.ucb.med_control.medControl.dto.MdhKinshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/kinship")
public class MdhKinshipAPI {

    private MdhKinshipBL mdhKinshipBL;

    @Autowired
    public MdhKinshipAPI(MdhKinshipBL mdhKinshipBL) {
        this.mdhKinshipBL = mdhKinshipBL;
    }

    @GetMapping
    public List<MdhKinshipDTO> getAllKinships() {
        System.out.println("getAllKinships");
        System.out.println(mdhKinshipBL.findAll());
        return mdhKinshipBL.findAll();
    }

    @GetMapping(path = "/{id}")
    public MdhKinshipDTO findKinshipById(@PathVariable("id") Integer idKinship) {
        return mdhKinshipBL.findById(idKinship);
    }

}
