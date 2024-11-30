import org.junit.Assert;
import org.junit.Test;

public class WorkerTest {

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
        Worker[] workers = getSampleWorkers();

        Worker[] sortedWorkers = Worker.sort(workers);

        Assert.assertArrayEquals(sortedWorkers, getSampleWorkersSorted());
    }

    @Test
    public void SortIsSortedMany(){
        Worker[] workers = Worker.workerCreator(1000);

        Worker[] sortedWorkers = Worker.sort(workers);

        for (int i = 1; i < workers.length; i++){
            if (sortedWorkers[i-1].getSalary() > sortedWorkers[i].getSalary())
                Assert.fail();
        }
        Assert.assertEquals(1000, workers.length);
    }

    @Test
    public void SortNoMissing(){
        Worker[] workers = Worker.workerCreator(1000);

        Worker[] sortedWorkers = Worker.sort(workers);

        for (int i = 0; i < workers.length; i++){
            boolean exists = false;

            for (int j = 0; j < sortedWorkers.length; j++)
                exists |= workers[i].equals(sortedWorkers[j]);

            if (!exists)
                Assert.fail("There is a worker missing");
        }
        Assert.assertEquals(1000, workers.length);
    }

    @Test
    public void SortNoDuplicate(){
        Worker[] workers = Worker.workerCreator(1000);

        Worker[] sortedWorkers = Worker.sort(workers);

        for (int i = 0; i < workers.length; i++){
            int workerCount = 0;

            for (int j = 0; j < sortedWorkers.length; j++)
                workerCount += (workers[i].equals(sortedWorkers[j])) ? 1 : 0;

            if (workerCount > 1)
                Assert.fail("The same worker appears more than once");
        }
        Assert.assertEquals(1000, workers.length);
    }
}
