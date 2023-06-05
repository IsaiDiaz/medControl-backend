package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.MdiAtentionDayRepository;
import bo.edu.ucb.med_control.medControl.dto.MdiAtentionDayDTO;
import bo.edu.ucb.med_control.medControl.entity.MdiAtentionDay;
import org.springframework.stereotype.Service;

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

    public List<MdiAtentionDay> findAll(){
        return mdiAtentionDayRepository.findAll();
    }
    public MdiAtentionDayDTO save(MdiAtentionDayDTO mdiAtentionDayDTO){
        MdiAtentionDay mdiAtentionDay = new MdiAtentionDay();
        mdiAtentionDay.setAtentionDayName(mdiAtentionDayDTO.getAtentionDayName());
        mdiAtentionDay.setStatus(mdiAtentionDayDTO.isStatus());
        mdiAtentionDay.setTxDate(new Date());
        mdiAtentionDay.setTxHost("localhost");
        mdiAtentionDay.setTxUser(1);
        mdiAtentionDay.setVersion(mdiAtentionDayDTO.getVersion());
        mdiAtentionDayRepository.saveAndFlush(mdiAtentionDay);
        return mdiAtentionDayDTO;
    }
}
