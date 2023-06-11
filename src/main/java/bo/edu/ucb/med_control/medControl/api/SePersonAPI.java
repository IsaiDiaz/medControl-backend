package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.SeUserBL;
import bo.edu.ucb.med_control.medControl.dto.SePersonDTO;
import bo.edu.ucb.med_control.medControl.bl.SePersonBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/person")
public class SePersonAPI {
    private SePersonBL sePersonBL;

    @Autowired
    public SePersonAPI(SePersonBL sePersonBL) {
        this.sePersonBL = sePersonBL;
    }

    @GetMapping(path = "/{id}")
    public SePersonDTO findPersonById(@PathVariable Integer id, @RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }else{
            return null;
        }
        if(SeUserBL.validateToken(token)){
            return sePersonBL.findById(id);
        }else{
            return null;
        }

    }

    @PostMapping
    public SePersonDTO createPerson(@RequestBody Map<String, Object> request) {
        SePersonDTO sePersonDTO = new SePersonDTO();
        String host = (String) request.get("host");
        sePersonDTO.setPersonName((String) request.get("personName"));
        sePersonDTO.setPersonEmail((String) request.get("personEmail"));
        sePersonDTO.setPersonPhone((String) request.get("personPhone"));
        sePersonDTO.setStatus(true);
        sePersonDTO.setTxUser(1);
        sePersonDTO.setTxHost(host);
        sePersonDTO.setTxDate(new java.util.Date());
        return sePersonBL.saveSePerson(sePersonDTO);
    }

}
