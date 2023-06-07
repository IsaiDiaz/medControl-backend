package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dto.SeUserDTO;
import bo.edu.ucb.med_control.medControl.entity.SeUser;
import bo.edu.ucb.med_control.medControl.dao.SeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeUserBL {
    private final SeUserRepository seUserRepository;

    @Autowired
    public SeUserBL(SeUserRepository seUserRepository) {
        this.seUserRepository = seUserRepository;
    }

    public List<SeUserDTO> getAllSeUsers() {
        List<SeUser> seUsers = seUserRepository.findAll();
        return seUsers.stream()
                .map(SeUserDTO::new)
                .collect(Collectors.toList());
    }

    public SeUserDTO getSeUserById(Integer id) {
        Optional<SeUser> seUserOptional = seUserRepository.findById(id);
        return seUserOptional.map(SeUserDTO::new).orElse(null);
    }

    public SeUserDTO saveSeUser(SeUserDTO seUserDTO) {
        SeUser seUser = seUserDTO.toEntity();
        SeUser savedSeUser = seUserRepository.save(seUser);
        return new SeUserDTO(savedSeUser);
    }

    public SeUserDTO updateSeUser(Integer id, SeUserDTO seUserDTO) {
        Optional<SeUser> seUserOptional = seUserRepository.findById(id);
        if (seUserOptional.isPresent()) {
            SeUser seUser = seUserOptional.get();
            seUser.setUsername(seUserDTO.getUsername());
            seUser.setSecret(seUserDTO.getSecret());
            seUser.setUserPictureId(seUserDTO.getUserPictureId());
            seUser.setVersion(seUserDTO.getVersion());
            seUser.setStatus(seUserDTO.isStatus());
            seUser.setTxUser(seUserDTO.getTxUser());
            seUser.setTxHost(seUserDTO.getTxHost());
            seUser.setTxDate(seUserDTO.getTxDate());
            SeUser updatedSeUser = seUserRepository.save(seUser);
            return new SeUserDTO(updatedSeUser);
        }
        return null;
    }

    public boolean deleteSeUser(Integer id) {
        Optional<SeUser> seUserOptional = seUserRepository.findById(id);
        if (seUserOptional.isPresent()) {
            seUserRepository.delete(seUserOptional.get());
            return true;
        }
        return false;
    }
}
