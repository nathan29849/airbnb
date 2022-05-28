package team15.airbnb.domain.accommodation;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
	@Column(name = "event_name")
	private String name;

	@Column(name = "event_image")
	private String image;
}
