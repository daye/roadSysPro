package exam_vo.monitor;

import java.io.Serializable;

public class MonitorSessionVo implements Serializable {

	private String sessionId = "";
	
	private String createtime = "";
	
	private String livetime = "";
	
	private String lastAccessedTime = "";

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(String lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public String getLivetime() {
		return livetime;
	}

	public void setLivetime(String livetime) {
		this.livetime = livetime;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	
	
}
