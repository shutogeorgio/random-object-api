package mvctuto.mvctuto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Value
public class WordRequest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;

    public WordRequest(long id, String name){
        this.id = id;
        this.name = name;
    }
}
