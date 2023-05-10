package com.gahyun.firstproject.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class SessionGroup {
    private String room;
    private WebSocketSession session;
}


@Component
public class WebSocketProvider extends TextWebSocketHandler{

    private List<SessionGroup> sessionList = new ArrayList<>();
    // 연결
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		String room = session.getHandshakeHeaders().getFirst("room");
		session.getId();
		sessionList.add(new SessionGroup(room, session));
		System.out.println(room + "/ " + session.getId() + "Web socket connected"); 
	
    }

    // 메세지 송수신
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String room = session.getHandshakeHeaders().getFirst("room");
	
        for(SessionGroup sessionGroup : sessionList) {
            if(sessionGroup.getRoom().equals(room)){
                sessionGroup.getSession().sendMessage(message);
            }
        }

            System.out.println(room + "/ " + session.getId() + "Web socket connected"); 
	}

    // 연결 해제
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        for(SessionGroup sessionGroup : sessionList) {
            if(sessionGroup.getSession().equals(session)){
                sessionList.remove(sessionGroup);
            }	
        }
    
        //System.out.println(sessionGroup.getId() + "closed!");

	}

}

