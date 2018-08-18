package sideprojects.ndumiso.budgetapp.domain.abstraction;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected LocalDateTime createdOn;

    @Column
    protected  String createdBy;
}
