import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Program {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            URL url = new URL ("https://reqbin.com/echo/post/json");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestMethod("POST");
            String jsonInputString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";

            try {
                OutputStream os = con.getOutputStream();
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            //OutputStreamWriter os = new OutputStreamWriter(con.getOutputStream());
            //os.write(jsonInputString);


            System.out.println(con.getResponseCode());
        }
        catch (Exception e){
            System.out.println("some thing was wrong!!!!!!!");
        }
    }
}
