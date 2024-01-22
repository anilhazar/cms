package com.anil.vtys.cms.model.mapper.branch;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.entity.BranchEntity;

import java.util.List;

/**
 * {@link BranchEntity} Entity nesneleri ile {@link Branch} Domain model nesneleri arasındaki
 * mapleme işlemlerini yürüten mapper sınıftır.
 */
public class BranchMapper {

    /**
     * Parametre olarak verilen {@link BranchEntity} Entity nesnesini <br>
     * {@link Branch} Domain Model nesnesine dönüştüren metoddur.
     * @param branchEntity
     * @return
     */
    public static Branch toDomainModel(
            final BranchEntity branchEntity
    ) {
        return Branch.builder()
                .id(branchEntity.getId())
                .name(branchEntity.getName())
                .build();
    }

    /**
     * Parametre olarak verilen {@link BranchEntity} Entity nesnelerini <br>
     * {@link Branch} Domain Model nesnelerine dönüştüren metoddur.
     * @param branchEntities
     * @return
     */
    public static List<Branch> toDomainModel(
            final List<BranchEntity> branchEntities
    ) {
        return branchEntities.stream()
                .map(BranchMapper::toDomainModel)
                .toList();
    }

    /**
     * Parametre olarak verilen {@link Branch} Domain Model nesnesini <br>
     * {@link BranchEntity} Entity nesnesine dönüştüren metoddur.
     * @param branchDomainModel
     * @return
     */
    public static BranchEntity toEntity(
            final Branch branchDomainModel
    ) {
        return BranchEntity.builder()
                .id(branchDomainModel.getId())
                .name(branchDomainModel.getName())
                .build();
    }
}
