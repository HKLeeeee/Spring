package hello.advanced.trace;

import java.util.UUID;

import lombok.Getter;

@Getter
public class TraceId {
	public String id;
	public int level;

	public TraceId() {
		this.id = createId();
		this.level = 0;
	}

	private TraceId(String id, int level) {
		this.id = id;
		this.level = level;
	}

	public String createId() {
		return UUID.randomUUID().toString().substring(0,8);
	}

	public TraceId createNextId(){
		return new TraceId(id, level + 1);
	}

	public TraceId createPrevId(){
		return new TraceId(id, level - 1);
	}

	public boolean isFirstLevel(){
		return level == 0;
	}
}
