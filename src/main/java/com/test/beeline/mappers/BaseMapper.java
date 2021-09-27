package com.test.beeline.mappers;

public interface BaseMapper <E, D>{
    D mapToDto(E entity);

    E mapToEntity(D dto);
}
