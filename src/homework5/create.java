package homework5;

public class create {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000.00, 30);
        persArray[1] = new Person("Ivanov Pavel", "Engineer", "ivivan@mailbox.com", "89231231772", 30000.00, 40);
        persArray[2] = new Person("Ivanov Anton", "Engineer", "ivivan@mailbox.com", "892312312", 30000.00, 50);
        persArray[3] = new Person("Ivanov Alexandr", "Engineer", "ivivan@mailbox.com", "892312312", 30000.00, 40);
        persArray[4] = new Person("Ivanov Peter", "Engineer", "ivivan@mailbox.com", "892312312", 30000.00, 33);
        for (Person pers: persArray){
            if (pers.getAge()>=40){
                pers.info();
            }
        }
    }
}
