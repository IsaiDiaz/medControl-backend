package bo.edu.ucb.med_control.medControl;

import bo.edu.ucb.med_control.medControl.bl.MdiAtentionDayBL;
import bo.edu.ucb.med_control.medControl.dao.MdiAtentionDayRepository;
import bo.edu.ucb.med_control.medControl.entity.MdiAtentionDay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedControlApplicationTests {

    @Autowired
    private MdiAtentionDayBL mdiAtentionDayBL;
    @Autowired
    private MdiAtentionDayRepository mdiAtentionDayRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void save_ShoulSaveAtentionDayToDatabase() {
        MdiAtentionDay mdiAtentionDay = new MdiAtentionDay();
        mdiAtentionDay.setAtentionDayName("Lunes");
        mdiAtentionDay.setStatus(true);
        mdiAtentionDay.setTxDate(new Date());
        mdiAtentionDay.setTxHost("localhost");
        mdiAtentionDay.setTxUser(1);
        mdiAtentionDay.setVersion(1);
        mdiAtentionDayRepository.saveAndFlush(mdiAtentionDay);
        System.out.println("ID: " + mdiAtentionDay.getAtentioinDayId());

        assertNotNull(mdiAtentionDay.getAtentioinDayId());
    }


}
