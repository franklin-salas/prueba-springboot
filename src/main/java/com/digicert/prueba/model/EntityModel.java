package com.digicert.prueba.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntityModel {

    protected Boolean isDeleted = false;
}
