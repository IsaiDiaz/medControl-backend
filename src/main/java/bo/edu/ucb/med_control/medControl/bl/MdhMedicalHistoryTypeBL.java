package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.MdhMedicalHistoryTypeRepository;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistoryType;
import bo.edu.ucb.med_control.medControl.dto.MdhMedicalHistoryTypeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MdhMedicalHistoryTypeBL {
    private MdhMedicalHistoryTypeRepository mdhMedicalHistoryTypeRepository;

    public MdhMedicalHistoryTypeBL(MdhMedicalHistoryTypeRepository mdhMedicalHistoryTypeRepository) {
        this.mdhMedicalHistoryTypeRepository = mdhMedicalHistoryTypeRepository;
    }

    public MdhMedicalHistoryType save(MdhMedicalHistoryType mdhMedicalHistoryType){
        return mdhMedicalHistoryTypeRepository.save(mdhMedicalHistoryType);
    }

    @Transactional(readOnly = true)
    public List<MdhMedicalHistoryTypeDTO> findAll(){
        List<MdhMedicalHistoryTypeDTO> mdhMedicalHistoryTypeDTOS = new ArrayList<>();
        List<MdhMedicalHistoryType> mdhMedicalHistoryTypes = mdhMedicalHistoryTypeRepository.findAll();
        for (MdhMedicalHistoryType mdhMedicalHistoryType : mdhMedicalHistoryTypes){
            MdhMedicalHistoryTypeDTO mdhMedicalHistoryTypeDTO = new MdhMedicalHistoryTypeDTO(mdhMedicalHistoryType);
            mdhMedicalHistoryTypeDTOS.add(mdhMedicalHistoryTypeDTO);
        }
        return mdhMedicalHistoryTypeDTOS;
    }
    public MdhMedicalHistoryTypeDTO saveAndFlush(MdhMedicalHistoryTypeDTO mdhMedicalHistoryTypeDTO){
        MdhMedicalHistoryType mdhMedicalHistoryType = new MdhMedicalHistoryType();
        mdhMedicalHistoryType.setMedicalHistoryName(mdhMedicalHistoryTypeDTO.getMedicalHistoryName());
        mdhMedicalHistoryType.setStatus(mdhMedicalHistoryTypeDTO.isStatus());
        mdhMedicalHistoryType.setTxDate(new Date());
        mdhMedicalHistoryType.setTxHost(mdhMedicalHistoryTypeDTO.getTxHost());
        mdhMedicalHistoryType.setTxUser(mdhMedicalHistoryTypeDTO.getTxUser());
        mdhMedicalHistoryType.setVersion(mdhMedicalHistoryTypeDTO.getVersion());
        mdhMedicalHistoryType = mdhMedicalHistoryTypeRepository.saveAndFlush(mdhMedicalHistoryType);
        return new MdhMedicalHistoryTypeDTO(mdhMedicalHistoryType);
    }

    public MdhMedicalHistoryTypeDTO findById(Integer id){
        MdhMedicalHistoryType mdhMedicalHistoryType = mdhMedicalHistoryTypeRepository.findById(id).get();
        return new MdhMedicalHistoryTypeDTO(mdhMedicalHistoryType);
    }
}
