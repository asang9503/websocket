package com.yyx.studentad.controller;

import com.yyx.studentad.constant.ConstantForAllPage;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/**
 * 阿桑
 * 2019/3/19
 * @author Nvarchar
 */
@ServerEndpoint("/msg/{username}")
@Component
public class WebSocketController {
    static Logger logger = Logger.getLogger("webSocket");
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketController> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;
    private String username = "Admin";

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        this.session = session;
        webSocketSet.add(this);
        session.setMaxTextMessageBufferSize(ConstantForAllPage.MAXWORD);
        addOnlineCount();
        logger.info("有新成员加入:" + username + ",当前在线人数为" + getOnlineCount());
        this.username = username;
        sendMsg("欢迎" + username + "进入聊天室");
    }

    @OnClose
    public void onClose(@PathParam("username") String username) {
        webSocketSet.remove(this);
        subOnlineCount();
        String msg = username + "退出聊天！当前在线人数为" + getOnlineCount();
        sendMsg(msg);
        logger.info(msg);
    }

    @OnMessage
    public void onMessage(String msg, Session session, @PathParam("username") String username) {
        if (msg != null && msg != "") {
            logger.info("收到来自用户" + username + "的消息:" + msg);
//            char type = msg.charAt(0);
//            if (type == ConstantForAllPage.ONE) {

            for (WebSocketController webSocketController : webSocketSet) {
                webSocketController.sendMsg(msg);
            }
//                sendMsg(msg);
//            } else {
//                sendMsg(msg);
//            }
        } else {
            logger.info("有空数据传入");
        }

    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.warning("发生错误");
        error.printStackTrace();
    }

    public void sendMsg(String msg){
        this.session.getAsyncRemote().sendText(msg);
    }

    public void sendMsg(String msg, String username){
//        webSocketMap.forEach((s,w)-> {
//            if (s.equals(username)) {
//                w.session.getAsyncRemote().sendText(msg);
//            }
//        });
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketController.onlineCount--;
    }
}