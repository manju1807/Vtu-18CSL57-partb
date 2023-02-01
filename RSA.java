import java.util.Scanner;
public class RSA {
static int gcd(int m, int n) {
while (n != 0) {
int r = m % n;
m = n;
n = r;
}
return m;
}
public static void main(String args[]) {
    int p, q, n, e, d, phi;
    int[] count = new int[100];
    int[] enc = new int[100];
    int[] dec = new int[100];
    int i, j, len;
    Scanner read = new Scanner(System.in);
    String msg;
    
    System.out.println("Enter the Message to be encrypted:");
    msg = read.nextLine();
    System.out.println("Enter value of p and q\n");
    p = read.nextInt();
    q = read.nextInt();
    n = p * q;
    phi = (p - 1) * (q - 1);
    for (i = 2; i < phi; i++) {
        if (gcd(i, phi) == 1) {
            break;
        }
    }
    e = i;
    for (i = 2; i < phi; i++) {
        if ((e * i - 1) % phi == 0) {
            break;
        }
    }
    d = i;
    len = msg.length();
    for (i = 0; i < len; i++) {
        char c = msg.charAt(i);
        if (c == ' ') {
            count[i] = 26;
        } else {
            count[i] = c - 96;
        }
    }
    for (i = 0; i < len; i++) {
        enc[i] = 1;
        for (j = 0; j < e; j++) {
            enc[i] = (enc[i] * count[i]) % n;
        }
    }
    System.out.println("\nEncrypted message\n");
    for (i = 0; i < len; i++) {
        System.out.print(enc[i]);
        System.out.print(" ");
    }
    
    System.out.println("\nDecrypted message\n");
    for (i = 0; i < len; i++) {
        dec[i] = 1;
        for (j = 0; j < d; j++) {
            dec[i] = (dec[i] * enc[i]) % n;
        }
        if (dec[i] == 26) {
            System.out.print(" ");
        } else {
            System.out.print((char)(dec[i] + 96));
        }
    }
    read.close();
}
}
