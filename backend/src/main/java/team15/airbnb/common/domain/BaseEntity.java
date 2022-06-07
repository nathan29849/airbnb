package team15.airbnb.common.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@NotNull
	private boolean isDeleted;

	@NotNull
	@Column(columnDefinition = "TIMESTAMP")
	@CreatedDate
	private LocalDateTime createdAt;

	@NotNull
	@Column(columnDefinition = "TIMESTAMP")
	@LastModifiedDate
	private LocalDateTime lastModifiedAt;

	protected void changeDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
