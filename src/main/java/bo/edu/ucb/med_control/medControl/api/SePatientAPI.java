package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.SePatientBL;
import bo.edu.ucb.med_control.medControl.dto.SePatientDTO;
import bo.edu.ucb.med_control.medControl.dto.SeUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/patient")
public class SePatientAPI {
    private final SePatientBL sePatientBL;

    @Autowired
    public SePatientAPI(SePatientBL sePatientBL) {
        this.sePatientBL = sePatientBL;
    }

    @GetMapping
    public ResponseEntity<List<SePatientDTO>> getAllSePatients() {
        List<SePatientDTO> sePatients = sePatientBL.getAllSePatients();
        return new ResponseEntity<>(sePatients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SePatientDTO> getSePatientById(@PathVariable Integer id) {
        SePatientDTO sePatient = sePatientBL.findById(id);
        if (sePatient != null) {
            return new ResponseEntity<>(sePatient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<SePatientDTO> saveSePatient(@RequestBody Map<String, Object> request) {
        BigDecimal patientHeight = new BigDecimal(String.valueOf(request.get("patientHeight")));
        BigDecimal patientWeight = new BigDecimal(String.valueOf(request.get("patientWeight")));
        String patientGender = (String) request.get("patientGender");
        Integer userId = (Integer) request.get("userId");
        String host = (String) request.get("host");

        SePatientDTO sePatientDTO = new SePatientDTO();
        sePatientDTO.setPatientHeight(patientHeight);
        sePatientDTO.setPatientWeight(patientWeight);
        sePatientDTO.setPatientGender(patientGender);
        sePatientDTO.setStatus(true);
        sePatientDTO.setTxUser(userId);
        sePatientDTO.setTxDate(new java.util.Date());
        sePatientDTO.setTxHost(host);

        sePatientDTO.setUserId(new SeUserDTO(userId));

        SePatientDTO savedSePatient = sePatientBL.saveSePatient(sePatientDTO);
        return new ResponseEntity<>(savedSePatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SePatientDTO> updateSePatient(@PathVariable Integer id, @RequestBody SePatientDTO sePatientDTO) {
        SePatientDTO updatedSePatient = sePatientBL.updateSePatient(id, sePatientDTO);
        if (updatedSePatient != null) {
            return new ResponseEntity<>(updatedSePatient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSePatient(@PathVariable Integer id) {
        if (sePatientBL.deleteSePatient(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
