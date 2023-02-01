import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPC {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        Socket socket = new Socket("localhost", 8080);
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(fileName);

        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        writer.close();
        output.close();
        reader.close();
        input.close();
        socket.close();
        scanner.close();
    }
}
