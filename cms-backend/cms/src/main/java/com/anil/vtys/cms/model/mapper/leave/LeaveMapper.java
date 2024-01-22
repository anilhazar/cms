package com.anil.vtys.cms.model.mapper.leave;

import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.entity.LeaveEntity;

import java.util.List;

/**
 * {@link LeaveEntity} Entity nesneleri ile {@link Leave} Domain Model nesneleri arasındaki
 * mapleme işlemlerini yürüten mapper sınıftır.
 */
public class LeaveMapper {

    /**
     * Parametre olarak verilen {@link LeaveEntity} Entity nesnesinden <br>
     * {@link Leave} Domain Model nesnesi oluşturan metoddur.
     * @param leaveEntity
     * @return
     */
    public static Leave toDomainModel(
            final LeaveEntity leaveEntity
    ) {
        return Leave.builder()
                .id(leaveEntity.getId())
                .reason(leaveEntity.getReason())
                .startDate(leaveEntity.getStartDate())
                .endDate(leaveEntity.getEndDate())
                .build();
    }

    /**
     * Parametre olarak verilen {@link LeaveEntity} Entity nesnelerinden <br>
     * {@link Leave} Domain Model nesneleri oluşturan metoddur.
     * @param leaveEntities
     * @return
     */
    public static List<Leave> toDomainModel(
            final List<LeaveEntity> leaveEntities
    ) {
        return leaveEntities.stream()
                .map(LeaveMapper::toDomainModel)
                .toList();
    }

    /**
     * Parametre olarak verilen {@link Leave} Domain Model nesnesinden <br>
     * {@link LeaveEntity} Entity nesnesi oluşturan metoddur.
     * @param leaveDomainModel
     * @return
     */
    public static LeaveEntity toEntity(
            final Leave leaveDomainModel
    ) {
        return LeaveEntity.builder()
                .id(leaveDomainModel.getId())
                .reason(leaveDomainModel.getReason())
                .startDate(leaveDomainModel.getStartDate())
                .endDate(leaveDomainModel.getEndDate())
                .build();
    }

}
