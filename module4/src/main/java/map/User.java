package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private String name;
    private String surname;
    private String birthDate;
    private int[] buyHistory;
    private List<User> children;

    public User() {
    }

    public User(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        buyHistory = new int[]{1,2,3,4,5};
        children = new ArrayList<>();
    }

    public List<User> getChildren() {
        return children;
    }

    public void setChildren(List<User> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int[] getBuyHistory() {
        return buyHistory;
    }

    public void setBuyHistory(int[] buyHistory) {
        this.buyHistory = buyHistory;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", buyHistory=" + Arrays.toString(buyHistory) +
                ", children=" + children +
                '}';
    }
}
