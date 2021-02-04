package probono.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@NamedQuery(query="select a from Activist a where a.activistId=:activistId", name="Activist.find")

@Entity
public class Activist {
	
	@Id
	@Column(name="activist_id", length=20, nullable=false)
	private String activistId;
	
	@Column(length=20, nullable=false)
	private String name;
	
	@Column(length=20, nullable=false)
	private String password;
	
	@Column(length=50, nullable=false)
	private String major;
	
	@OneToMany(mappedBy="activistId") //1:다 관계
	private List<Probono_project> project;
	

	

	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Activist [activistId=").append(activistId).append(", name=").append(name).append(", password=")
				.append(password).append(", major=").append(major).append("]");
		return builder.toString();
	}*/
}
