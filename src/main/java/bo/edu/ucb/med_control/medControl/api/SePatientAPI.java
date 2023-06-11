package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.*;
import bo.edu.ucb.med_control.medControl.dto.*;
import bo.edu.ucb.med_control.medControl.entity.*;
import bo.edu.ucb.med_control.medControl.filter.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/patient")
public class SePatientAPI implements WebMvcConfigurer {
    private final SePatientBL sePatientBL;
    private final AlgPatientAllergyBL algPatientAllergyBL;
    private final IllPatientIllnessBL illPatientIllnessBL;
    private final MdhMedicalHistoryBL mdhMedicalHistoryBL;
    @Autowired
    public SePatientAPI(SePatientBL sePatientBL, AlgPatientAllergyBL algPatientAllergyBL, IllPatientIllnessBL illPatientIllnessBL, MdhMedicalHistoryBL mdhMedicalHistoryBL) {
        this.sePatientBL = sePatientBL;
        this.algPatientAllergyBL = algPatientAllergyBL;
        this.illPatientIllnessBL = illPatientIllnessBL;
        this.mdhMedicalHistoryBL = mdhMedicalHistoryBL;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new TokenAuthenticationFilter())
        .addPathPatterns("/api/v1/patient/**");
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

    @GetMapping("/{patientId}/allergy")
    public ResponseEntity<List<AlgPatientAllergyDTO>> getPatientAllergies(@PathVariable Integer patientId) {
        List<AlgPatientAllergyDTO> allergies = algPatientAllergyBL.getPatientAllergies(patientId);
        return new ResponseEntity<>(allergies, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/illness")
    public ResponseEntity<List<IllPatientIllnessDTO>> getPatientIllnesses(@PathVariable Integer patientId) {
        List<IllPatientIllnessDTO> illnesses = illPatientIllnessBL.getPatientIllnesses(patientId);
        return new ResponseEntity<>(illnesses, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/medical-history")
    public ResponseEntity<List<MdhMedicalHistoryDTO>> getPatientMedicalHistories(@PathVariable Integer patientId) {
        List<MdhMedicalHistoryDTO> medicalHistories = mdhMedicalHistoryBL.getPatientMedicalHistories(patientId);
        return new ResponseEntity<>(medicalHistories, HttpStatus.OK);
    }

    @PostMapping("/{patientId}/allergy")
    public ResponseEntity<AlgPatientAllergyDTO> savePatientAllergy(@PathVariable Integer patientId, @RequestBody Map<String, Object> request) {
        Integer allergyId = (Integer) request.get("allergyId");
        String host = (String) request.get("host");
        Integer userId = (Integer) request.get("userId");
        String dateString = (String) request.get("diagnosticDate");
        Integer severityId = (Integer) request.get("severityId");

        Date diagnosticDate = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            diagnosticDate = dateFormat.parse(dateString);
        }catch (ParseException e){
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        AlgPatientAllergyDTO algPatientAllergyDTO = new AlgPatientAllergyDTO();
        algPatientAllergyDTO.setPatientId(new SePatientDTO(patientId));
        algPatientAllergyDTO.setAllergyId(new AlgAllergyDTO(allergyId));
        algPatientAllergyDTO.setPatientAllergyDiagnosticDate(diagnosticDate);
        algPatientAllergyDTO.setSeverityId(new AlgSeverityDTO(severityId));
        algPatientAllergyDTO.setStatus(true);
        algPatientAllergyDTO.setTxUser(userId);
        algPatientAllergyDTO.setTxDate(new java.util.Date());
        algPatientAllergyDTO.setTxHost(host);
        AlgPatientAllergyDTO savedAlgPatientAllergy = algPatientAllergyBL.savePatientAllergy(algPatientAllergyDTO);
        return new ResponseEntity<>(savedAlgPatientAllergy, HttpStatus.CREATED);
    }

    @PostMapping("/{patientId}/illness")
    public ResponseEntity<IllPatientIllnessDTO> savePatientIllness(@PathVariable Integer patientId, @RequestBody Map<String, Object> request){
        Integer illnessId = (Integer) request.get("illnessId");
        String host = (String) request.get("host");
        Integer userId = (Integer) request.get("userId");
        String dateString = (String) request.get("diagnosticDate");

        Date diagnosticDate = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            diagnosticDate = dateFormat.parse(dateString);
        }catch (ParseException e){
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        IllPatientIllnessDTO illPatientIllnessDTO = new IllPatientIllnessDTO();
        illPatientIllnessDTO.setIllnessDocumentId(1);
        illPatientIllnessDTO.setPatientId(new SePatientDTO(patientId));
        illPatientIllnessDTO.setPatientIllnessDiagnosticDate(diagnosticDate);
        illPatientIllnessDTO.setIllnessId(new IllIllnessDTO(illnessId));
        illPatientIllnessDTO.setStatus(true);
        illPatientIllnessDTO.setTxDate(1);
        illPatientIllnessDTO.setTxHost(host);
        illPatientIllnessDTO.setTxUser(userId);

        IllPatientIllnessDTO savedIllPatientIllness = illPatientIllnessBL.savePatientIllness(illPatientIllnessDTO);
        return new ResponseEntity<>(savedIllPatientIllness,HttpStatus.CREATED);
    }

    @PostMapping("/{patientId}/medical-history")
    public ResponseEntity<MdhMedicalHistoryDTO> savePatientMedicalHistory(@PathVariable Integer patientId, @RequestBody Map<String, Object> request){
        Integer medicalHistoryId = (Integer) request.get("medicalHistoryId");
        String host = (String) request.get("host");
        Integer userId = (Integer) request.get("userId");
        Integer kinshipId = (Integer) request.get("kinshipId");

        MdhMedicalHistoryDTO mdhMedicalHistoryDTO = new MdhMedicalHistoryDTO();
        mdhMedicalHistoryDTO.setMedicalHistoryTypeId(new MdhMedicalHistoryTypeDTO(medicalHistoryId));
        mdhMedicalHistoryDTO.setPatientId(new SePatientDTO(patientId));
        mdhMedicalHistoryDTO.setMedicalHistoryDocumentId(1);
        mdhMedicalHistoryDTO.setKinshipId(new MdhKinshipDTO(kinshipId));
        mdhMedicalHistoryDTO.setRelativesName("Relatives Name");
        mdhMedicalHistoryDTO.setStatus(true);
        mdhMedicalHistoryDTO.setTxDate(new java.util.Date());
        mdhMedicalHistoryDTO.setTxHost(host);
        mdhMedicalHistoryDTO.setTxUser(userId);

        MdhMedicalHistoryDTO savedMdhMedicalHistory = mdhMedicalHistoryBL.savePatientMedicalHistory(mdhMedicalHistoryDTO);
        return new ResponseEntity<>(savedMdhMedicalHistory,HttpStatus.CREATED);
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
