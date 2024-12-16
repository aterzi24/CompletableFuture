import java.util.function.Supplier;

public class MyCompletableFuture<T> {
    private T data;
    private boolean finished = false;
    private Thread thread;

    private MyCompletableFuture() {
    }

    public static <T> MyCompletableFuture<T> supplyAsync(Supplier<T> s) {
        MyCompletableFuture<T> response = new MyCompletableFuture<>();
        Thread t = new Thread(() -> {
            response.data = s.get();
            response.finished = true;
        });
        response.thread = t;
        t.start();
        return response;
    }

    public T get() throws InterruptedException {
        if (finished) {
            return data;
        }
        thread.join();
        return data;
    }
}
