package com.lrwin.event;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dulei on 1/17/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:should be temp data,record these login users.
 */
public class ParticipantRepository {

	private Map<String, LoginEvent> activeSessions = new ConcurrentHashMap<>();

	public void add(String sessionId, LoginEvent event) {
		activeSessions.put(sessionId, event);
	}

	public LoginEvent getParticipant(String sessionId) {
		return activeSessions.get(sessionId);
	}

	public void removeParticipant(String sessionId) {
		activeSessions.remove(sessionId);
	}

	public Map<String, LoginEvent> getActiveSessions() {
		return activeSessions;
	}

	public void setActiveSessions(Map<String, LoginEvent> activeSessions) {
		this.activeSessions = activeSessions;
	}

	public boolean exisEmail(String email){
		Iterator<String> iterable = activeSessions.keySet().iterator();
		boolean exist = false;
		while (iterable.hasNext()){
			if (activeSessions.get(iterable.next()).getEmail().equalsIgnoreCase(email)){
				exist = true;
			}
		}
		return exist;
	}
}
