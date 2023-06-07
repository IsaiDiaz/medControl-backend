package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.entity.IllIllness;
import bo.edu.ucb.med_control.medControl.dto.IllIllnessDTO;
import bo.edu.ucb.med_control.medControl.dao.IllIllnessRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import  java.util.Date;
import java.util.List;

@Service
public class IllIllnessBL {
    private IllIllnessRepository illIllnessRepository;

    public IllIllnessBL(IllIllnessRepository illIllnessRepository) {
        this.illIllnessRepository = illIllnessRepository;
    }

    public IllIllnessDTO saveAndFlush(IllIllnessDTO illIllnessDTO){
        IllIllness illIllness = new IllIllness();
        illIllness.setIllnessName(illIllnessDTO.getIllnessName());
        illIllness.setIllnesDescription(illIllnessDTO.getIllnesDescription());
        illIllness.setStatus(illIllnessDTO.isStatus());
        illIllness.setTxDate(new Date());
        illIllness.setTxHost(illIllnessDTO.getTxHost());
        illIllness.setTxUser(illIllnessDTO.getTxUser());
        illIllness.setVersion(illIllnessDTO.getVersion());
        return new IllIllnessDTO(illIllnessRepository.saveAndFlush(illIllness));
    }

    @Transactional(readOnly = true)
    public  List <IllIllnessDTO> findAll(){
        List<IllIllnessDTO> illIllnessDTOS= new ArrayList<>();
        List<IllIllness> illnesses = illIllnessRepository.findAll();
        for (IllIllness illIllness :illnesses) {
            illIllness.getIllPatientIllnessList().size();
            illIllnessDTOS.add(new IllIllnessDTO(illIllness));
        }
        return illIllnessDTOS;
    }

    public IllIllnessDTO findById(Integer id){
        IllIllness illIllness = illIllnessRepository.findById(id).get();
        return new IllIllnessDTO(illIllness);
    }
}
