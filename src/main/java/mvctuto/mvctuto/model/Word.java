package mvctuto.mvctuto.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "word")
@Getter
@Setter
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;

	public Word() {
	}

	public Word(long id, String name) {
		this.id = id;
		this.name = name;
	}

}
