package com.dmb.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "The username cannot be null")
	@Column(name="username")
	private String username;

	@NotNull(message = "The password cannot be null")
	@Column(name="password")
	private String password;

	@NotNull(message = "The email cannot be null")
	@Column(name="email")
	private String email;

	@NotNull(message = "The worker_code cannot be null")
	@Column(name="worker_code")
	private String worker_code;

	@OneToMany
	@JoinColumn(name = "FK_parties_created")
	private List<Party> party;

	@OneToMany
	@JoinColumn(name = "FK_party_members")
	private List<Party_Member> party_member;

	@OneToMany
	@JoinColumn(name = "FK_messages_sender")
	private List<Message> message;


	public User() {
	}

	public User(Long id, String username, String password, String email, String worker_code) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.worker_code = worker_code;
	}


	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getWorker_code() {
		return worker_code;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party")
	public List<Party> getParty() {
		return party;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party_Member")
	public List<Party_Member> getParty_member() {
		return party_member;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessage() {
		return message;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWorker_code(String worker_code) {
		this.worker_code = worker_code;
	}

	public void setParty(List<Party> party) {
		this.party = party;
	}

	public void setParty_member(List<Party_Member> party_member) {
		this.party_member = party_member;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

}
