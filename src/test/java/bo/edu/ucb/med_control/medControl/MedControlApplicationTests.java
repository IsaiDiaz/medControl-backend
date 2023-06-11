package bo.edu.ucb.med_control.medControl;

import bo.edu.ucb.med_control.medControl.bl.*;
import bo.edu.ucb.med_control.medControl.dao.*;
import bo.edu.ucb.med_control.medControl.dto.*;
import bo.edu.ucb.med_control.medControl.entity.*;
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

    @Autowired
    private AlgAllergyBL algAllergyBL;

    @Autowired
    private AlgAllergyRepository algAllergyRepository;

    @Autowired
    private IllIllnessRepository illIllnessRepository;

    @Autowired
    private IllIllnessBL illIllnessBL;

    @Autowired
    private SePersonRepository sePersonRepository;

    @Autowired
    private SePersonBL sePersonBL;

    @Autowired
    private SeUserBL seUserBL;

    @Autowired
    private SeUserRepository seUserRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void save_ShoulSaveAtentionDayToDatabase() {
        MdiAtentionDay mdiAtentionDay = new MdiAtentionDay();
        mdiAtentionDay.setAtentionDayName("Viernes");
        mdiAtentionDay.setStatus(true);
        mdiAtentionDay.setTxDate(new Date());
        mdiAtentionDay.setTxHost("localhost");
        mdiAtentionDay.setTxUser(1);
        mdiAtentionDay.setVersion(1);
        MdiAtentionDayBL mdiAtentionDayBL = new MdiAtentionDayBL(mdiAtentionDayRepository);
        MdiAtentionDayDTO mdiAtentionDayDTO = new MdiAtentionDayDTO(
                mdiAtentionDay
        );
        MdiAtentionDayDTO newMdiAtentionDayDTO = mdiAtentionDayBL.saveAndFlush(mdiAtentionDayDTO);
        System.out.println("ID: " + mdiAtentionDayDTO.getAtentionDayId());

        assertNotNull(newMdiAtentionDayDTO.getAtentionDayId());
    }

    @Test
    public void save_ShouldSaveAndFlushAlgAllergy (){
        AlgAllergy algAllergy = new AlgAllergy();
        algAllergy.setAllergyName("Polen");
        algAllergy.setAllergyDescription("Alergia al polen");
        algAllergy.setStatus(true);
        algAllergy.setTxDate(new Date());
        algAllergy.setTxHost("localhost");
        algAllergy.setTxUser(1);
        algAllergy.setVersion(1);
        AlgAllergyBL algAllergyBL = new AlgAllergyBL(algAllergyRepository);
        AlgAllergyDTO algAllergyDTO = new AlgAllergyDTO(
                algAllergy
        );
        AlgAllergyDTO newAlgAllergyDTO = algAllergyBL.saveAndFlush(algAllergyDTO);
        System.out.println("ID: " + newAlgAllergyDTO.getAllergyId());

        assertNotNull(newAlgAllergyDTO.getAllergyId());
    }

    @Test
    public void findAll_ShouldReturnAllAlgAllergies(){
        List<AlgAllergyDTO> algAllergyList = algAllergyBL.findAll();
        System.out.println("Allergies: " + algAllergyList);
        assertNotNull(algAllergyList);
    }

    @Test
    public void save_ShouldSaveAndFlushIllIllness (){
        IllIllness illIllness = new IllIllness();
        illIllness.setIllnessName("Bronquitis");
        illIllness.setIllnesDescription("Inflamacion de los bronquios");
        illIllness.setStatus(true);
        illIllness.setTxDate(new Date());
        illIllness.setTxHost("localhost");
        illIllness.setTxUser(1);
        illIllness.setVersion(1);
        IllIllnessBL illIllnessBL = new IllIllnessBL(illIllnessRepository);
        IllIllnessDTO illIllnessDTO = new IllIllnessDTO(
                illIllness
        );
        IllIllnessDTO newIllIllnessDTO = illIllnessBL.saveAndFlush(illIllnessDTO);
        System.out.println("ID: " + newIllIllnessDTO.getIllnessId());

        assertNotNull(newIllIllnessDTO.getIllnessId());
    }

    @Test
    public void findAll_ShouldReturnAllIllIllnesses(){
        List<IllIllnessDTO> illIllnessList = illIllnessBL.findAll();
        System.out.println("Illnesses: " + illIllnessList);
        assertNotNull(illIllnessList);
    }

    @Test
    public void save_ShouldSaveAndFlushSePerson(){
        SePersonDTO sePersonDTO = new SePersonDTO();
        sePersonDTO.setPersonEmail("jsoza057@gmail.com");
        sePersonDTO.setPersonName("Jose Isai Diaz Soza");
        sePersonDTO.setPersonPhone("77555510");
        sePersonDTO.setStatus(true);
        sePersonDTO.setTxDate(new Date());
        sePersonDTO.setTxHost("localhost");
        sePersonDTO.setTxUser(1);
        sePersonDTO.setVersion(1);
        SePersonBL sePersonBL = new SePersonBL(sePersonRepository);
        sePersonDTO = sePersonBL.saveSePerson(sePersonDTO);
        System.out.println("ID: " + sePersonDTO.getPersonId());
        assertNotNull(sePersonDTO.getPersonId());
    }

    @Test
    public void save_ShouldSaveAndFlushSeUser(){
        SeUserDTO seUserDTO = new SeUserDTO();
        seUserDTO.setUsername("joeDoe");
        seUserDTO.setSecret("123456");
        seUserDTO.setUserPictureId(1);
        SePersonDTO sePersonDTO = new SePersonDTO();
        sePersonDTO.setPersonId(2);
        seUserDTO.setPersonId(sePersonDTO);
        seUserDTO.setStatus(true);
        seUserDTO.setTxDate(new Date());
        seUserDTO.setTxHost("localhost");
        seUserDTO.setTxUser(1);
        seUserDTO.setVersion(1);
        SeUserBL seUserBL = new SeUserBL(seUserRepository);
        seUserDTO = seUserBL.saveSeUser(seUserDTO);
        System.out.println("ID: " + seUserDTO.getUserId());
        assertNotNull(seUserDTO.getUserId());
    }

}
