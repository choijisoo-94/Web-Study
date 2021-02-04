package probono.model.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recipient {
	
	@Id
	@Column(name="recepient_id", length=20 , nullable=false)
	private String recepeientId;
	
	@Column(length=20, nullable=false)
	private String name;
	
	@Column(length=20, nullable=false)
	private String password;
	
	@Column(length=50, nullable=false)
	private String receiveContent;
	
	@OneToMany(mappedBy="receiveId") //1:다 관계
	private List<Probono_project> project;
	
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipient [id=").append(id).append(", name=").append(name).append(", password=")
				.append(password).append(", receiveContent=").append(receiveContent).append("]");
		return builder.toString();
	}*/
}