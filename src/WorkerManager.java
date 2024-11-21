import java.util.Random;

public class WorkerManager {

    private Worker[] workers;

    public WorkerManager(Worker[] workers){
        this.workers = workers;
    }

    public WorkerManager(){
        this.workers = workerCreator(10000);
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
