public class Main {

    public static void main(String[] args) {
        WorkerManager manager = new WorkerManager(WorkerManager.workerCreator(10000));

        //System.out.println("====================================\nThe workers before the sorting:\n");
        manager.sort();
        //System.out.println("====================================\nThe workers after the sorting:\n" );
    }
}
