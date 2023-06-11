package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dto.SeUserDTO;
import bo.edu.ucb.med_control.medControl.entity.SeUser;
import bo.edu.ucb.med_control.medControl.dao.SeUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeUserBL {
    private final SeUserRepository seUserRepository;
    private static final SecretKey secretKey= Keys.secretKeyFor(SignatureAlgorithm.HS256);
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

    public SeUserDTO findById(Integer id) {
        Optional<SeUser> seUserOptional = seUserRepository.findById(id);
        return seUserOptional.map(SeUserDTO::new).orElse(null);
    }

    public SeUserDTO saveSeUser(SeUserDTO seUserDTO) {
        String salt = seUserDTO.getUsername();
        System.out.println("Salt: " + salt);

        // Concatenate the salt and the original password
        String passwordWithSalt = seUserDTO.getSecret() + salt;
        System.out.println("Password with salt: " + passwordWithSalt);

        // Hash the password with the salt
        String hashedPassword = hashPassword(passwordWithSalt);
        System.out.println("Hashed password: " + hashedPassword);

        // Store the hashed password in the DTO
        seUserDTO.setSecret(hashedPassword);

        return new SeUserDTO(seUserRepository.save(seUserDTO.toEntity()));
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

    public SeUserDTO findByUsername(String username) {
        SeUser seUser = seUserRepository.findByUsername(username);
        Optional<SeUser> seUserOptional = Optional.ofNullable(seUser);
        System.out.println("User: " + seUser);
        return seUserOptional.map(SeUserDTO::new).orElse(null);
    }

    public boolean deleteSeUser(Integer id) {
        Optional<SeUser> seUserOptional = seUserRepository.findById(id);
        if (seUserOptional.isPresent()) {
            seUserRepository.delete(seUserOptional.get());
            return true;
        }
        return false;
    }

    public boolean authenticate(String username, String secret) {
        // Buscar el usuario por nombre de usuario
        SeUserDTO userDTO = findByUsername(username);
        System.out.println("User: " + userDTO);
        if (userDTO != null) {
            // Obtener la contraseña hash del usuario
            String hashedPassword = userDTO.getSecret();
            String salt = username;
            System.out.println("Hashed password: " + hashedPassword);
            // Concatenar la contraseña ingresada con la sal del usuario
            String passwordWithSalt = secret + salt;
            System.out.println("Password with salt: " + passwordWithSalt);
            // Obtener el hash de la contraseña ingresada con la sal
            String hashedPasswordWithSalt = hashPassword(passwordWithSalt);
            System.out.println("Hashed password with salt: " + hashedPasswordWithSalt);

            // Verificar si el hash coincide con el almacenado en la base de datos
            return hashedPassword.equals(hashedPasswordWithSalt);
        }

        return false;
    }

    private String hashPassword(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(password.getBytes());
            return bytesToHex(hashedBytes);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }

    private String bytesToHex(byte[] bytes){
        StringBuilder hexString = new StringBuilder();
        for(byte b : bytes){
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            String username = claims.getBody().getSubject();
            Date expiration = claims.getBody().getExpiration();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String generateToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 86400000); // 24 hours

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuer("MedControl API")
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();
        return token;
    }

}
