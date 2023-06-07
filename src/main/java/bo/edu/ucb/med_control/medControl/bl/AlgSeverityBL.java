package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.AlgSeverityRepository;
import bo.edu.ucb.med_control.medControl.entity.AlgSeverity;
import bo.edu.ucb.med_control.medControl.dto.AlgSeverityDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import  java.util.Date;
import java.util.List;

@Service
public class AlgSeverityBL {
    private AlgSeverityRepository algSeverityRepository;

    public AlgSeverityBL(AlgSeverityRepository algSeverityRepository) {
        this.algSeverityRepository = algSeverityRepository;
    }

    public AlgSeverityDTO saveAndFlush(AlgSeverityDTO algSeverityDTO){
        AlgSeverity algSeverity = new AlgSeverity();
        algSeverity.setSeverityName(algSeverityDTO.getSeverityName());
        algSeverity.setStatus(algSeverityDTO.isStatus());
        algSeverity.setTxDate(new Date());
        algSeverity.setTxHost(algSeverityDTO.getTxHost());
        algSeverity.setTxUser(algSeverityDTO.getTxUser());
        algSeverity.setVersion(algSeverityDTO.getVersion());
        return new AlgSeverityDTO(algSeverityRepository.saveAndFlush(algSeverity));
    }

    @Transactional(readOnly = true)
    public  List <AlgSeverityDTO> findAll(){
        List<AlgSeverityDTO> algSeverityDTOS= new ArrayList<>();
        List<AlgSeverity> severities = algSeverityRepository.findAll();
        for (AlgSeverity algSeverity :severities) {
            algSeverity.getAlgPatientAllergyList().size();
            algSeverityDTOS.add(new AlgSeverityDTO(algSeverity));
        }
        return algSeverityDTOS;
    }

    public AlgSeverityDTO findById(Integer id){
        AlgSeverity algSeverity = algSeverityRepository.findById(id).get();
        return new AlgSeverityDTO(algSeverity);
    }
}
