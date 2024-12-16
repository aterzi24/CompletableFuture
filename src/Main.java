public class Main {
    public static void main(String[] args) throws InterruptedException {
        // finished is true
        MyCompletableFuture<Integer> result1 = MyCompletableFuture.supplyAsync(() -> 5);
        Thread.sleep(1000);
        System.out.println(result1.get());

        // finished is false
        MyCompletableFuture<Integer> result2 = MyCompletableFuture.supplyAsync(Main::func);
        System.out.println(result2.get());
    }

    static int func() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 15;
    }
}