import java.io.*;
import java.net.*;

public class TCPS {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String fileName = reader.readLine();
        File file = new File(fileName);
        if (file.exists()) {
            OutputStream output = socket.getOutputStream();
            FileInputStream fileInput = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int count;
            while ((count = fileInput.read(buffer)) >= 0) {
                output.write(buffer, 0, count);
            }
            output.close();
            fileInput.close();
        }
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
