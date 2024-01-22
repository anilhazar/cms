package com.anil.vtys.cms.repository;

import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.entity.EmployeeEntity;
import com.anil.vtys.cms.model.entity.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, Long> {

    /**
     * Parametre olarak verilen {@link EmployeeEntity} ile ilişkili bütün <br>
     * {@link LeaveEntity} nesnelerini bir Liste içerisinde geriye dönen metoddur.
     * Nesneleri StartDate alanına göre DESC (Azalan) sırada döner.
     *
     * @param employeeEntity
     * @return
     */
    List<LeaveEntity> findLeaveEntitiesByEmployeeEntityOrderByStartDateDesc(
            final EmployeeEntity employeeEntity
    );
}
