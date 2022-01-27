package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import java.util.List;

public interface EntityMapper<D, E> {

	D toDto(E entity);

	List<D> toDto(List<E> entityList);

	List<E> toEntity(List<D> dtoList);

	E toEntity(D dto);

}
