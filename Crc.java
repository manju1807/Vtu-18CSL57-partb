import java.util.*;

public class Crc {

  void div(int[] a, int k) {
    int[] gp = {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
    int count = 0;
    for (int i = 0; i < k; i++) {
      if (a[i] == gp[0]) {
        for (int j = i; j < 17 + i; j++) {
          a[j] = a[j] ^ gp[count++];
        }
        count = 0;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[100];
    int[] b = new int[100];
    int len, k;
    Crc ob = new Crc();
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the length of Data Frame:");
    len = sc.nextInt();
    int flag = 0;

    System.out.println("Enter the Message:");
    for (int i = 0; i < len; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < 16; i++) {
      a[len++] = 0;
    }
    k = len - 16;
    for (int i = 0; i < len; i++) {
      b[i] = a[i];
    }
    ob.div(a, k);
    for (int i = 0; i < len; i++) {
      a[i] = a[i] ^ b[i];
    }
    System.out.println("Data to be transmitted: ");
    for (int i = 0; i < len; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    System.out.println("Enter the Received Data: ");
    for (int i = 0; i < len; i++) {
      a[i] = sc.nextInt();
    }
    ob.div(a, k);
    for (int i = 0; i < len; i++) {
      if (a[i] != 0) {
        flag = 1;
        break;
      }
    }
    if (flag == 1) {
      System.out.println("Error in data");
    } else {
      System.out.println("No error");
    }
  }
}
