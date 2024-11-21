import java.util.Random;

public class WorkerManager {

    private Worker[] workers;

    public WorkerManager(Worker[] workers){
        this.workers = workers;
    }

    public WorkerManager(){
        this.workers = workerCreator(10000);
    }

    public Worker[] getWorkers(){ return workers; }

    public int getWorkerCount() { return workers.length; }

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
    public void sort(){
        long timeBeforeSort = System.currentTimeMillis();

        mergeSort(workers, workers.length);

        long timeAfterSort = System.currentTimeMillis();
        System.out.printf("The time it took to sort is %d, i.e. %.3f seconds\n", (timeAfterSort - timeBeforeSort), ((float)(timeAfterSort - timeBeforeSort))/1000.0);
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


    @Override
    public String toString(){
        StringBuilder workersText = new StringBuilder();
        for (int curWorker = 0; curWorker < workers.length - 1; curWorker++){
            workersText.append(workers[curWorker]);
            workersText.append("\n");
        }
        return workersText.toString();
    }

    public static Worker[] workerCreator(final int workerCounter){
        Worker[] newWorkers = new Worker[workerCounter];
        Random rng = new Random();
        for (int i = 0; i < workerCounter; i++){
            int salary = 3000 + rng.nextInt(12000);
            newWorkers[i] = new Worker("John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", salary);
        }
        return newWorkers;
    }
}
