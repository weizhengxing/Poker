import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Player {
	private int playerId = IpInfo.PlayerId;
	private String playerName = "Meilier";
	private int playerMoney;

	public Player() {
		new SocketConnection();
	}

	public String RegMsg() { // 向服务器注册自己的id和name
		return SocketConnection.SendMsg(Message.REG_MSG + " " + playerId + " playerName" + " \n");
	}

	public String AnalysisMsg() { // 解析消息并处理消息
		return msgType(SocketConnection.ReadMsg()[0]);
	}

	public String msgType(String msg) { // 解析消息
		if (msg.equals(Message.SEAT_INFO_MSG_START)) {
			seatInfoMsgHandle();
			return Message.SEAT_INFO_MSG_START; // 在此处处理座次消息
		}
		if (msg.equals(Message.GAME_OVER_MSG)) {
			gameOverMsgHandle();
			return Message.GAME_OVER_MSG; // 在此处处理游戏结束消息
		}
		if (msg.equals(Message.BLIND_MSG_START)) {
			blindMsgHandle();
			return Message.BLIND_MSG_START;// 在这里处理盲注消息
		}
		if (msg.equals(Message.HOLD_CARD_MSG_START)) { // 在此处处理手牌消息
			holdCardMsgHandle();
			return Message.HOLD_CARD_MSG_START;
		}
		if (msg.equals(Message.INQUIRE_MSG_START)) {
			inquireMsgHandle();
			return Message.INQUIRE_MSG_START; // 在这里处理询问消息
		}
		if (msg.equals(Message.FLOP_MSG_START)) {
			flopMsgHandle();
			return Message.FLOP_MSG_START; // 在这里处理公牌消息
		}
		if (msg.equals(Message.TURN_MSG_START)) {
			turnMsgHandle();
			return Message.TURN_MSG_START; // 在这里处理转牌消息
		}
		if (msg.equals(Message.RIVER_MSG_START)) {
			riverMsgHandle();
			return Message.RIVER_MSG_START; // 在这里处理河牌消息
		}
		if (msg.equals(Message.SHOW_DOWN_MSG_START)) {
			showDownMsgHandle();
			return Message.SHOW_DOWN_MSG_START; // 在这里处理摊牌消息
		}
		if (msg.equals(Message.POT_WIN_MSG_START)) {
			potWinMsgHandle();
			return Message.POT_WIN_MSG_START; // 在这里处理奖池分配消息
		}
		return "ERROR";
	}

	private void seatInfoMsgHandle() {
		
	}

	private void gameOverMsgHandle() {
		SocketConnection.CloseConnection();
	}

	private void blindMsgHandle() {
		
	}

	private void holdCardMsgHandle() {
		
	}

	private void inquireMsgHandle() {
		SocketConnection.SendMsg(" all in ");
	}

	private void flopMsgHandle() {

	}

	private void turnMsgHandle() {

	}

	private void riverMsgHandle() {

	}

	private void showDownMsgHandle() {

	}

	private void potWinMsgHandle() {

	}

	/*
	 * public String SeatInfoMsg() { return SocketConnection.ReadMsg(); }
	 * 
	 * public String GameOverMag() { return SocketConnection.ReadMsg(); }
	 * 
	 * public String BlindMsg() { return SocketConnection.ReadMsg();
	 * 
	 * }
	 * 
	 * public String HoldCardsMsg() { return SocketConnection.ReadMsg();
	 * 
	 * }
	 * 
	 * public String InquireMsg() { return SocketConnection.ReadMsg();
	 * 
	 * }
	 */

	public String ActionMsg(String msg) {
		return SocketConnection.SendMsg(msg);

	}
	/*
	 * public String FlopMsg() { return SocketConnection.ReadMsg();
	 * 
	 * }
	 * 
	 * public String TurnMsg() { return SocketConnection.ReadMsg();
	 * 
	 * }
	 * 
	 * public String RiverMsg() { return SocketConnection.ReadMsg();
	 * 
	 * }
	 * 
	 * public String ShowDownMsg() { return SocketConnection.ReadMsg();
	 * 
	 * }
	 * 
	 * public String PotWinMsg() { return SocketConnection.ReadMsg(); }
	 */
}
