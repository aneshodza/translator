package ah.com.backend.Model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @class: UserData
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

@Entity
public class UserData {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String username;
    private String password;
    private LocalDate accountCreation;
    private int amountPoints;

    public UserData(Long id, String username, String password, int amountPoints) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountCreation = LocalDate.now();
        this.amountPoints = amountPoints;
    }

    public UserData() { }

    public void addPoint() {
        amountPoints++;
    }

    public void initializeDate() {
        accountCreation = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getAccountCreation() {
        return accountCreation;
    }

    public int getAmountPoints() {
        return amountPoints;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountCreation=" + accountCreation +
                '}';
    }
}
