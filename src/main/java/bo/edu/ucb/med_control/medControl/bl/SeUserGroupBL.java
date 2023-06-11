package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.SeUserGroupRepository;
import bo.edu.ucb.med_control.medControl.dto.SeUserGroupDTO;
import bo.edu.ucb.med_control.medControl.entity.SeUserGroup;
import  org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SeUserGroupBL {

    private SeUserGroupRepository seUserGroupRepository;

    @Autowired
    public SeUserGroupBL(SeUserGroupRepository seUserGroupRepository) {
        this.seUserGroupRepository = seUserGroupRepository;
    }

    public SeUserGroupDTO saveSeUserGroup(SeUserGroupDTO seUserGroupDTO){
        SeUserGroup seUserGroup = seUserGroupDTO.toEntity();
        seUserGroup = seUserGroupRepository.saveAndFlush(seUserGroup);
        return new SeUserGroupDTO(seUserGroup);
    }

}
