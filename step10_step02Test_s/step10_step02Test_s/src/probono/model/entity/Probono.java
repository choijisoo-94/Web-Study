package probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
public class Probono{
	@Id
	@Column(name="probono_id", length=50)
	private String probonoId;
	
	@Column(length=50, nullable=false)
	private String name;

	@Column(length=200, nullable=false)
	private String purpose;
	
	@OneToOne(mappedBy="probonoId") //1:1 관계
	private Probono_project project;
	
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Probono [probonoId=").append(probonoId).append(", name=").append(name).append(", purpose=")
		.append(purpose).append("]");
		return builder.toString();
	}*/
	
}