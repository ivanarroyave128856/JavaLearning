package flightreservationsystem.models;

public class Person {
    private String identification;
    private String identificationType;
    private String FirstName;
    private String SecondName;
    private String firstSurname;
    private String secondSurname;
    private short age;
    private String sex;
    private Double weight;
    private String phoneNumber;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public Person(String identification, String identificationType, String firstName, String secondName,
                  String firstSurname, String secondSurname, short age, String sex, Double weight,
                  String phoneNumber) {
        this.identification = identification;
        this.identificationType = identificationType;
        FirstName = firstName;
        SecondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
    }
}
