package sideprojects.ndumiso.budgetapp.service.abstraction;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ndumiso on 1/28/2018.
 */
public interface AbstractCrudService<T> {

    /**
     * finds all T entities
     *
     * @return a list of type T
     */
    List<T> findAll();

    /**
     * finds T by id
     *
     * @param id
     * @return T
     */

    Optional<T> findById(Long id);

    /**
     * saves T to database
     *
     * @param entity
     * @return T
     */

    T create(T entity);

    /**
     * updates the entity T
     *
     * @param entity
     * @return T
     */

    T update(T entity);
}
