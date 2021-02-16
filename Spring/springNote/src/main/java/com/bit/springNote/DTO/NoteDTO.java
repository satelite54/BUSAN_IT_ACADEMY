package com.bit.springNote.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor //생성자 자동 생성
//@Getter
//@Setter
public class NoteDTO {
	private int id;
	private String writer;
	public NoteDTO(int id, String writer, String content) {
		super();
		this.id = id;
		this.writer = writer;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String content;
}
