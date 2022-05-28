package team15.airbnb.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class BaseEntity {

	@NotNull
	private boolean isDeleted;

	@NotNull
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;

	@NotNull
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime lastModifiedAt;
}
