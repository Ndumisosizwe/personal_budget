package sideprojects.ndumiso.budgetapp.domain.abstraction;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@MappedSuperclass
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "Entity_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Entity_Gen", initialValue = 13, allocationSize = 3_000_000_00)
    protected Long id;

    @Column
    protected LocalDateTime createdOn;

    @Column
    protected  String createdBy;
}
