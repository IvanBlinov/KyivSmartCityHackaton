package com.ksc.schedule.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DozerMapper {

    <T> T map(Object source, Class<T> destinationClass);

    void map(Object source, Object destination);

    <T> List<T> mapList(Iterable<?> sources, Class<T> destinationClass);

    <T> Page<T> mapPage(Page<?> sourcePage, Class<T> destinationClass, Pageable pageable, int totalSize);

}
