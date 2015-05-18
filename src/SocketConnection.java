import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class SocketConnection {
	private static Socket player = null;// 静态类每个进程维护同一个链接
	private static StringBuilder mStringBuilder;
	private static String MsgType[];
	private static PrintWriter printWriter = null;
	private static InputStreamReader streamReader = null;// InputStreamReader是低层和高层串流之间的桥梁
	private static BufferedReader reader = null; // player.getInputStream()从Socket取得输入串流

		// 向服务器端发送请求，服务器IP地址和服务器监听的端口号


	public SocketConnection() {
		try {
			player = new Socket(IpInfo.ServerIp, IpInfo.ServerPort);
			// 通过printWriter 来向服务器发送消息
			printWriter = new PrintWriter(player.getOutputStream());
			printWriter.println(Message.REG_MSG + " " + 2333 + " playerName" + " \n");
			printWriter.flush();
			System.out.println("连接已建立...");
			streamReader = new InputStreamReader(player.getInputStream());
			// 链接数据串流，建立BufferedReader来读取，将BufferReader链接到InputStreamReder
			reader = new BufferedReader(streamReader);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static String SendMsg(String msg) { // 发送消息
		printWriter.println(msg);
		printWriter.flush();
		return msg;
	}

	public static String[] ReadMsg() {
		int i = 0;
		String servermsg = null;
		try {
			while ((servermsg = reader.readLine()) != null) {
				mStringBuilder.append(servermsg); // 添加消息
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 提取消息
		MsgType = mStringBuilder.toString().split(" ");
		return MsgType;
	}

	public static void CloseConnection() {
		try {
			player.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] getMsgList() {
		return MsgType;
	}

	public static Socket getSocket() {
		return player;

	}

	public static PrintWriter getPrintWriter() {
		return printWriter;
	}
}
