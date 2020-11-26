public class Traffic_Police {
    int PoliceID;
    public String Name;     //police-name
    private int Salary;
    private int Age;
    public int YearsOfExperience;
    private String Address;

    public Traffic_Police(int policeID, String name, int salary, int age, int yearsOfExperience, String address) {
        PoliceID = policeID;
        Name = name;
        Salary = salary;
        Age = age;
        YearsOfExperience = yearsOfExperience;
        Address = address;
    }
}
