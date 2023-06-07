package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.MdhKinshipRepository;
import bo.edu.ucb.med_control.medControl.entity.MdhKinship;
import bo.edu.ucb.med_control.medControl.dto.MdhKinshipDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MdhKinshipBL {
    private MdhKinshipRepository mdhKinshipRepository;

    public MdhKinshipBL(MdhKinshipRepository mdhKinshipRepository) {
        this.mdhKinshipRepository = mdhKinshipRepository;
    }

    public MdhKinshipDTO saveAndFlush(MdhKinshipDTO mdhKinshipDTO){
        MdhKinship mdhKinship = new MdhKinship();
        mdhKinship.setKinshipName(mdhKinshipDTO.getKinshipName());
        mdhKinship.setKinshipDescription(mdhKinshipDTO.getKinshipDescription());
        mdhKinship.setStatus(mdhKinshipDTO.isStatus());
        mdhKinship.setTxDate(new Date());
        mdhKinship.setTxHost(mdhKinshipDTO.getTxHost());
        mdhKinship.setTxUser(mdhKinshipDTO.getTxUser());
        mdhKinship.setVersion(mdhKinshipDTO.getVersion());
        mdhKinship = mdhKinshipRepository.saveAndFlush(mdhKinship);
        return new MdhKinshipDTO(mdhKinship);
    }

    @Transactional(readOnly = true)
    public  List <MdhKinshipDTO> findAll(){
        List<MdhKinshipDTO> mdhKinshipDTOS= new ArrayList<>();
        List<MdhKinship> illnesses = mdhKinshipRepository.findAll();
        for (MdhKinship mdhKinship : illnesses){
            MdhKinshipDTO mdhKinshipDTO = new MdhKinshipDTO(mdhKinship);
            mdhKinshipDTOS.add(mdhKinshipDTO);
        }
        return mdhKinshipDTOS;
    }

    public MdhKinshipDTO findById(Integer kinshipId){
        MdhKinship mdhKinship = mdhKinshipRepository.findById(kinshipId).get();
        return new MdhKinshipDTO(mdhKinship);
    }
}
