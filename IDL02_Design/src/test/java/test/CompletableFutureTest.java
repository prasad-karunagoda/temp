package test;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    
    @Test
    public void test() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return "Supplier result";
        }).thenAccept(System.out::println);

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
