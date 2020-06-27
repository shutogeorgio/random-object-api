package mvctuto.mvctuto.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class WordRequest implements Serializable {

	@NotEmpty
	private String name;

	public WordRequest() {
	}

	public WordRequest(String name) {
		this.name = name;
	}

}
