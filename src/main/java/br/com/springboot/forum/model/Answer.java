package br.com.springboot.forum.model;




import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Answer {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	@ManyToOne
	private Thread thread;
	private LocalDateTime creationDate = LocalDateTime.now();
	@ManyToOne
	private User author;
	private Boolean solution = false;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMensagem(String message) {
		this.message = message;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Boolean getSolution() {
		return solution;
	}

	public void setSolution(Boolean solution) {
		this.solution = solution;
	}

}
