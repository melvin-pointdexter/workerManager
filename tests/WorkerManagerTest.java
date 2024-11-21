import org.junit.Assert;
import org.junit.Test;

public class WorkerManagerTest {

    public Worker[] getSampleWorkers(){
        Worker[] workers = {new Worker("AAA","John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 9000),
                new Worker("BBB", "John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 8000),
                new Worker("CCC", "John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 4000),
                new Worker("DDD","John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 6000)};
        return workers;
    }

    public Worker[] getSampleWorkersSorted(){
        Worker[] workers = {new Worker("CCC", "John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 4000),
                new Worker("DDD","John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 6000),
                new Worker("BBB", "John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 8000),
                new Worker("AAA","John", "Doe", "John.Doe@yahoo.com", "051-234-5678", "308 Negra Arroyo Lane", 9000)};
        return workers;
    }

    @Test
    public void SortIsSortedFew(){
        WorkerManager manager = new WorkerManager(getSampleWorkers());

        manager.sort();

        Assert.assertArrayEquals(manager.getWorkers(), getSampleWorkersSorted());
    }

    @Test
    public void SortIsSortedMany(){
        WorkerManager manager = new WorkerManager(WorkerManager.workerCreator(1000));

        manager.sort();

        Worker[] workers = manager.getWorkers();

        for (int i = 1; i < workers.length; i++){
            if (workers[i-1] != workers[i])
                Assert.fail();
        }
        Assert.assertEquals(workers.length, 1000);
    }

    @Test
    public void SortNoMissing(){
        //TODO
    }

    @Test
    public void SortNoDuplicate(){
        //TODO
    }
}
