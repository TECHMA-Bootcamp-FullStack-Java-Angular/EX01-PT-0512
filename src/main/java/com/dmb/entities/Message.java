package com.dmb.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "The content cannot be null")
	@Column(name = "content")
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_sent")
	private LocalDateTime time_sent;

	@ManyToOne
	@JoinColumn(name = "sender")
	private User sender;

	@ManyToOne
	@JoinColumn(name = "party")
	private Party party;

	public Message() {
		this.time_sent = LocalDateTime.now();
	}

	public Message(Long id, String content, User sender, Party party) {
		this.id = id;
		this.content = content;
		this.time_sent = LocalDateTime.now();
		this.sender = sender;
		this.party = party;
	}


	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getTime_sent() {
		return time_sent;
	}

	public User getSender() {
		return sender;
	}

	public Party getParty() {
		return party;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTime_sent(LocalDateTime time_sent) {
		this.time_sent = time_sent;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}
