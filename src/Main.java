public class Main {

    public static void main(String[] args) {
        Worker[] workers = Worker.workerCreator(10000);
        Worker[] sortedWorkers = Worker.sort(workers);

        System.out.printf("Workers after sorting:");
        printWorkers(sortedWorkers);
    }

    public static void printWorkers(Worker[] workers){
        for (Worker worker : workers) {
            System.out.println(worker.toString());
        }
    }
}
