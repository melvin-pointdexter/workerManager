import java.util.Random;

public class Worker {

    static int currentWorkerID = 100000000;
    private final String ID;
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

    public Worker(String ID, String firstName, String lastName, String email, String phoneNumber, String address, int salary){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public int getSalary() { return this.salary; }

    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;

        if (o.getClass() != this.getClass())
            return false;

        final Worker otherWorker = (Worker) o;
        return this.ID.equals(otherWorker.ID);
    }

    /* Bubble sort version of sort (has O(n^2) complexity):
        for (int curCycle = 0; curCycle < workers.length; curCycle++){
                for (int curWorker = 0; curWorker < workers.length - 1; curWorker++){
                    if (workers[curWorker].getSalary() > workers[curWorker + 1].getSalary()) {
                        Worker workerHolder = workers[curWorker];
                        workers[curWorker] = workers[curWorker + 1];
                        workers[curWorker + 1] = workerHolder;
                    }
                }
            }
     */

    //current sort uses merge sort
    public static Worker[] sort(Worker[] originalWorkers){
        Worker[] workers = originalWorkers.clone();
        long timeBeforeSort = System.currentTimeMillis();

        mergeSort(workers, workers.length);

        long timeAfterSort = System.currentTimeMillis();
        System.out.printf("The time it took to sort is %d milliseconds, i.e. %.3f seconds\n", (timeAfterSort - timeBeforeSort), ((float)(timeAfterSort - timeBeforeSort))/1000.0);
        return workers;
    }

    public static void mergeSort(Worker[] curSubArray, int length) {
        if (length < 2)
            return;

        int mid = length / 2;
        Worker[] left = new Worker[mid];
        Worker[] right = new Worker[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = curSubArray[i];
            right[i] = curSubArray[i+mid];
        }

        if (length % 2 == 1)
            right[right.length - 1] = curSubArray[curSubArray.length - 1];

        mergeSort(left, mid);
        mergeSort(right, length - mid);

        merge(curSubArray, left, right, mid, length - mid);
    }

    public static void merge(
            Worker[] curSubArray, Worker[] left, Worker[] right, int leftLength, int rightLength) {

        int leftTracker = 0, rightTracker = 0, mergedTracker = 0;
        //merge and compare the arrays
        while (leftTracker < leftLength && rightTracker < rightLength) {
            if (left[leftTracker].getSalary() < right[rightTracker].getSalary())
                curSubArray[mergedTracker++] = left[leftTracker++];
            else
                curSubArray[mergedTracker++] = right[rightTracker++];
        }
        //stuff the leftovers back into the array
        while (leftTracker < leftLength) {
            curSubArray[mergedTracker++] = left[leftTracker++];
        }
        while (rightTracker < rightLength) {
            curSubArray[mergedTracker++] = right[rightTracker++];
        }
    }

    public static Worker[] workerCreator(final int workerCounter){
        Worker[] newWorkers = new Worker[workerCounter];
        Random rnd = new Random();
        for (int i = 0; i < workerCounter; i++){
            int salary = 3000 + rnd.nextInt(12000);
            newWorkers[i] = new Worker("John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", salary);
        }
        return newWorkers;
    }

    @Override
    public String toString(){
        return String.format("Worker %s %s #%s, works from %s with contacts %s %s receives salary %d", this.firstName, this.lastName, this.ID, this.address, this.phoneNumber, this.email, this.salary);
    }
}
