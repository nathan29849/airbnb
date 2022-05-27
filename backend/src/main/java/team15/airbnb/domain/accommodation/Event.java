package team15.airbnb.domain.accommodation;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import team15.airbnb.domain.BaseEntity;

@Entity
public class Event extends BaseEntity {

	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String eventName;

	@NotNull
	private String eventImage;
}
