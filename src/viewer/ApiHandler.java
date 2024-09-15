package viewer;

import java.net.URI;
import java.net.http.*;

public class ApiHandler extends Thread{

    private LWindow window;
    private String prev;

    public ApiHandler(LWindow lWindow){
        window = lWindow;
        prev = "";
    }

    private void updateText(String text){
        System.out.println(text);
        System.out.println(prev);
        if(!prev.equals(text)) {
            if (text.equals("-1")) {
                window.updateText("");
            } else {
                window.updateText(text);
            }
        }
        prev = text;
    }


    @Override
    public void run() {
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("http://81.169.152.161:5011/get-number"))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String[] temp = response.body().toString().split(":");
                temp = temp[1].split("\"");
                this.updateText(temp[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
