package service;

import dao.UserDAO;
import model.User;
import util.Validator;

/**
 * Lietotāju reģistrācijas un pieslēgšanās biznesa loģika: ievadīto datu pārbaude pirms darba ar datubāzi.
 */
public class UserService {

    private final UserDAO userDAO;

    /**
     * Izveido servisu ar noklusēto datu piekļuves objektu.
     */
    public UserService() {
        this(new UserDAO());
    }

    /**
     * Izveido servisu ar norādīto datu piekļuves objektu.
     *
     * @param userDAO lietotāju datu piekļuves objekts
     */
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Pārbauda ievadītos datus un reģistrē jaunu klientu (funkcija T2).
     *
     * @param firstName vārds
     * @param lastName uzvārds
     * @param username lietotājvārds
     * @param email e-pasta adrese
     * @param password parole
     * @param confirmPassword paroles atkārtojums
     * @return jaunā lietotāja identifikators
     * @throws BusinessException ja dati nav derīgi vai lietotājvārds jau eksistē
     */
    public int register(String firstName, String lastName, String username, String email,
            String password, String confirmPassword) throws BusinessException {
        if (Validator.isBlank(firstName) || Validator.isBlank(lastName) || Validator.isBlank(username)
                || Validator.isBlank(email) || Validator.isBlank(password) || Validator.isBlank(confirmPassword)) {
            throw new BusinessException("Aizpildiet visus laukus.");
        }
        if (!Validator.isValidName(firstName) || !Validator.isValidName(lastName)) {
            throw new BusinessException("Vārds un uzvārds drīkst saturēt tikai burtus.");
        }
        if (!Validator.isValidUsername(username)) {
            throw new BusinessException("Lietotājvārdam jābūt 3-30 rakstzīmes garam (burti a-z, cipari un _).");
        }
        if (!Validator.isValidEmail(email.trim())) {
            throw new BusinessException("Nepareizs e-pasta formāts.");
        }
        if (!Validator.isValidPassword(password)) {
            throw new BusinessException("Parolei jābūt vismaz " + Validator.MIN_PASSWORD_LENGTH + " rakstzīmes garai.");
        }
        if (!password.equals(confirmPassword)) {
            throw new BusinessException("Paroles nesakrīt.");
        }
        if (userDAO.existsByUsername(username)) {
            throw new BusinessException("Lietotājvārds jau eksistē.");
        }
        User user = new User(firstName.trim(), lastName.trim(), username, email.trim(), User.ROLE_CUSTOMER);
        int id = userDAO.register(user, password);
        if (id == -1) {
            throw new BusinessException("Reģistrēšana neizdevās (e-pasts, iespējams, jau tiek izmantots).");
        }
        return id;
    }

    /**
     * Pārbauda lietotājvārdu un paroli (funkcija T1).
     *
     * @param username lietotājvārds
     * @param password parole
     * @return pieslēgušais lietotājs
     * @throws BusinessException ja lauki ir tukši vai dati nav pareizi
     */
    public User login(String username, String password) throws BusinessException {
        if (Validator.isBlank(username) || Validator.isBlank(password)) {
            throw new BusinessException("Ievadiet lietotājvārdu un paroli.");
        }
        User user = userDAO.login(username.trim(), password);
        if (user == null) {
            throw new BusinessException("Nepareizs lietotājvārds vai parole.");
        }
        return user;
    }
}
