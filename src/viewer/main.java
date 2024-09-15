package viewer;

public class main {

    public static void main(String[] args) {
        LWindow window = new LWindow();
        ApiHandler apiHandler = new ApiHandler(window);
        apiHandler.start();
    }
}
