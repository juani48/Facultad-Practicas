package SingleThreadTCPServer.SingleThreadTCPServer;

import java.io.PrintWriter;

public class PasswordServer extends SingleThreadTCPServer{

	@Override
	public void handleMessage(String message, PrintWriter out) {
		String[] strings = message.split("-");
		System.out.print(strings);
	}
	
	public static void main(String[] args) {
        new VoidServer().startLoop(args);
    }
}
