package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.MdiAtentionDayRepository;
import bo.edu.ucb.med_control.medControl.dto.MdiAtentionDayDTO;
import bo.edu.ucb.med_control.medControl.entity.MdiAtentionDay;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MdiAtentionDayBL {
    private MdiAtentionDayRepository mdiAtentionDayRepository;

    public MdiAtentionDayBL(MdiAtentionDayRepository mdiAtentionDayRepository) {
        this.mdiAtentionDayRepository = mdiAtentionDayRepository;
    }

    public MdiAtentionDay save(MdiAtentionDay mdiAtentionDay){
        return mdiAtentionDayRepository.save(mdiAtentionDay);
    }

    @Transactional(readOnly = true)
    public List<MdiAtentionDay> findAll(){
        return mdiAtentionDayRepository.findAll();
    }
    public MdiAtentionDayDTO saveAndFlush(MdiAtentionDayDTO mdiAtentionDayDTO){
        MdiAtentionDay mdiAtentionDay = new MdiAtentionDay();
        mdiAtentionDay.setAtentionDayName(mdiAtentionDayDTO.getAtentionDayName());
        mdiAtentionDay.setStatus(mdiAtentionDayDTO.isStatus());
        mdiAtentionDay.setTxDate(new Date());
        mdiAtentionDay.setTxHost(mdiAtentionDayDTO.getTxHost());
        mdiAtentionDay.setTxUser(mdiAtentionDayDTO.getTxUser());
        mdiAtentionDay.setVersion(mdiAtentionDayDTO.getVersion());
        mdiAtentionDay = mdiAtentionDayRepository.saveAndFlush(mdiAtentionDay);
        return new MdiAtentionDayDTO(mdiAtentionDay);
    }
}
