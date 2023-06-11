package bo.edu.ucb.med_control.medControl.api;

import bo.edu.ucb.med_control.medControl.bl.SePersonBL;
import bo.edu.ucb.med_control.medControl.bl.SeUserGroupBL;
import bo.edu.ucb.med_control.medControl.dto.SeGroupDTO;
import bo.edu.ucb.med_control.medControl.dto.SePersonDTO;
import bo.edu.ucb.med_control.medControl.dto.SeUserDTO;
import bo.edu.ucb.med_control.medControl.bl.SeUserBL;
import bo.edu.ucb.med_control.medControl.dto.SeUserGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class SeUserAPI {
    private SeUserBL seUserBL;
    private SeUserGroupBL seUserGroupBL;
    private SePersonBL sePersonBL;

    @Autowired
    public SeUserAPI(SeUserBL seUserBL, SeUserGroupBL seUserGroupBL, SePersonBL sePersonBL) {
        this.seUserBL = seUserBL;
        this.seUserGroupBL = seUserGroupBL;
        this.sePersonBL = sePersonBL;
    }

    @GetMapping(path = "/{id}")
    public SeUserDTO findUserById(@PathVariable Integer id) {
        return seUserBL.findById(id);
    }

    @PostMapping
    public SeUserDTO createUser(@RequestBody Map<String, Object> request) {
        // Obtener los campos del JSON
        String username = (String) request.get("username");
        String secret = (String) request.get("secret");
        Integer userPictureId = (Integer) request.get("userPictureId");
        String host = (String) request.get("host");
        Integer groupId = (Integer) request.get("group");
        Map<String, Object> personIdMap = (Map<String, Object>) request.get("personId");
        Integer personId = (Integer) personIdMap.get("personId");

        SeUserDTO seUserDTO = new SeUserDTO();
        seUserDTO.setUsername(username);
        seUserDTO.setSecret(secret);
        seUserDTO.setUserPictureId(userPictureId);
        seUserDTO.setPersonId(new SePersonDTO(personId));
        seUserDTO.setTxUser(1);
        seUserDTO.setTxHost(host);
        seUserDTO.setTxDate(new java.util.Date());
        seUserDTO.setStatus(true);

        SeUserDTO savedUserDTO = seUserBL.saveSeUser(seUserDTO);
        if(savedUserDTO != null && groupId != null){
            SeUserGroupDTO seUserGroupDTO = new SeUserGroupDTO();
            seUserGroupDTO.setGroupId(new SeGroupDTO(groupId));
            seUserGroupDTO.setUserId(savedUserDTO);
            seUserGroupDTO.setTxUser(savedUserDTO.getUserId());
            seUserGroupDTO.setTxHost(host);
            seUserGroupDTO.setTxDate(new java.util.Date());
            seUserGroupDTO.setStatus(true);
            seUserGroupBL.saveSeUserGroup(seUserGroupDTO);
        }

        savedUserDTO.setTxUser(savedUserDTO.getUserId());
        seUserBL.updateSeUser(savedUserDTO.getUserId(), savedUserDTO);
        SePersonDTO sePersonDTO = sePersonBL.findById(savedUserDTO.getPersonId().getPersonId());
        sePersonDTO.setTxUser(savedUserDTO.getUserId());
        sePersonBL.updateSePerson(sePersonDTO.getPersonId(), sePersonDTO);

        return savedUserDTO;
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> authenticateUser(@RequestBody Map<String, Object> request) {
        String username = (String) request.get("username");
        String secret = (String) request.get("secret");
        System.out.println("username: " + username);
        System.out.println("secret: " + secret);
        boolean authenticated = seUserBL.authenticate(username, secret);

        if (authenticated) {
            // Generar el JWT
            String token = seUserBL.generateToken(username);
            return ResponseEntity.ok("Token: " + token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

}
