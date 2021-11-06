package springboot.student.app.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customsqe")
public class CustomSqe {
	@Id
	private String id;
	private int sqe;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSqe() {
		return sqe;
	}
	public void setSqe(int sqe) {
		this.sqe = sqe;
	}
	

}
