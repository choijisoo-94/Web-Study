package probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
@Entity
public class Probono_project {
	
	@Id
	@Column(name="probono_project_id")
	private int probonoProjectId;
	
	@Column(name="probono_project_name", length=50, nullable=false)
	private String probonoProjectName;
	
	@OneToOne
	@JoinColumn(name="probono_id", nullable=false)
	private Probono probonoId;
	
	@ManyToOne
	@JoinColumn(name="activist_id", nullable=false)
	private Activist activistId;
	
	@ManyToOne
	@JoinColumn(name="recepient_id",nullable=false)
	private Recipient receiveId;
	
	@Column(name="project_content", length=100, nullable=false)
	private String projectContent;
	
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Probono_project [probonoProjectId=").append(probonoProjectId).append(", probonoProjectName=")
				.append(probonoProjectName).append(", probonoId=").append(probonoId).append(", activistId=")
				.append(activistId).append(", receiveId=").append(receiveId).append(", projectContent=")
				.append(projectContent).append("]");
		return builder.toString();
	}*/
}
