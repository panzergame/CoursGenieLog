import datamocklib.Server;

public class Main {
    public static void main(String[] args) {

        Server server = new Server();
        int result = server.sendServer("blabla");

        System.out.println(result);
    }
}
