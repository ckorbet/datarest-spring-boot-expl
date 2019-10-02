package com.cartorgon.drsbe.restrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartorgon.drsbe.mode.impl.BeverageEntity;

@RepositoryRestResource(collectionResourceRel = "beverages", path = "beverages")
public interface BeverageRestRepository extends JpaRepository<BeverageEntity, Long>{

}