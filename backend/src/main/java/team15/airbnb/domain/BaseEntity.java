package team15.airbnb.domain;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class BaseEntity {

	@NotNull
	private boolean delete_yn;

	@NotNull
	private LocalDateTime createdDate;

	@NotNull
	private LocalDateTime lastModifiedDate;
}
