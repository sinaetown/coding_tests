import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String given = br.readLine();
        if (given.contains("c=")) given = given.replace("c=", ".");
        if (given.contains("c-")) given = given.replace("c-", ".");
        if (given.contains("dz=")) given = given.replace("dz=", ".");
        if (given.contains("d-")) given = given.replace("d-", ".");
        if (given.contains("lj")) given = given.replace("lj", ".");
        if (given.contains("nj")) given = given.replace("nj", ".");
        if (given.contains("s=")) given = given.replace("s=", ".");
        if (given.contains("z=")) given = given.replace("z=", ".");
        System.out.println(given.length());
    }
}