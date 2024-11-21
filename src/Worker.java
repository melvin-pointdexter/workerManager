public class Worker {

    static int currentWorkerID = 1;
    private String ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private int salary;

    public Worker(String firstName, String lastName, String email, String phoneNumber, String address, int salary){
        this.ID = String.format("%09d", currentWorkerID++);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;

        if (o.getClass() != this.getClass())
            return false;

        final Worker otherWorker = (Worker) o;
        return this.ID.equals(otherWorker.ID);
    }

}
