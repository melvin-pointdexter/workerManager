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

    public void sort(){
        long timeBeforeSort = System.currentTimeMillis();

        for (int curCycle = 0; curCycle < workers.length; curCycle++){
            for (int curWorker = 0; curWorker < workers.length - 1; curWorker++){
                if (workers[curWorker].getSalary() > workers[curWorker + 1].getSalary()) {
                    Worker workerHolder = workers[curWorker];
                    workers[curWorker] = workers[curWorker + 1];
                    workers[curWorker + 1] = workerHolder;
                }
            }
        }

        long timeAfterSort = System.currentTimeMillis();
        System.out.printf("The time it took to sort is %d, i.e. %.3f seconds\n", (timeAfterSort - timeBeforeSort), ((float)(timeAfterSort - timeBeforeSort))/1000.0);
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
