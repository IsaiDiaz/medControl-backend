package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.AlgAllergyRepository;
import bo.edu.ucb.med_control.medControl.dto.AlgAllergyDTO;
import bo.edu.ucb.med_control.medControl.entity.AlgAllergy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import  java.util.Date;
import java.util.List;
@Service
public class AlgAllergyBL {
    private AlgAllergyRepository algAllergyRepository;

    public AlgAllergyBL(AlgAllergyRepository algAllergyRepository) {
        this.algAllergyRepository = algAllergyRepository;
    }

    public AlgAllergyDTO saveAndFlush(AlgAllergyDTO algAllergyDTO){
        AlgAllergy algAllergy = new AlgAllergy();
        algAllergy.setAllergyName(algAllergyDTO.getAllergyName());
        algAllergy.setAllergyDescription(algAllergyDTO.getAllergyDescription());
        algAllergy.setStatus(algAllergyDTO.isStatus());
        algAllergy.setTxDate(new Date());
        algAllergy.setTxHost(algAllergyDTO.getTxHost());
        algAllergy.setTxUser(algAllergyDTO.getTxUser());
        algAllergy.setVersion(algAllergyDTO.getVersion());
        return new AlgAllergyDTO(algAllergyRepository.saveAndFlush(algAllergy));
    }

    @Transactional(readOnly = true)
    public  List <AlgAllergyDTO> findAll(){
        List<AlgAllergyDTO> algAllergyDTOS= new ArrayList<>();
        List<AlgAllergy> allergies = algAllergyRepository.findAll();
        for (AlgAllergy algAllergy :allergies) {
            algAllergy.getAlgPatientAllergyList().size();
            algAllergyDTOS.add(new AlgAllergyDTO(algAllergy));
        }
        return algAllergyDTOS;
    }

    public AlgAllergyDTO findById(Integer id){
        AlgAllergy algAllergy = algAllergyRepository.findById(id).get();
        return new AlgAllergyDTO(algAllergy);
    }

}
