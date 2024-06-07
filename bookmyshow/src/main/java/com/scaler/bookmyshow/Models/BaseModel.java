package com.scaler.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass /* JPA Annotation to define a super class that contains all common fields and mapping information which is inherited by multiple child entity classes. */
@EntityListeners(AuditingEntityListener.class) /* This is specific to individual entities, enabling auditing for that particular entity. It automatically keeps tracking of certain actions in entities like creating or updating records. */
public class BaseModel {

    @Id /* JPA annotation that specifies primary key of an entity. */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastModifiedAt;

    private String updatedBy;
}
