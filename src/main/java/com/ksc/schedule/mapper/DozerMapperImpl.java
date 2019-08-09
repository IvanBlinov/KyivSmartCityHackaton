package com.ksc.schedule.mapper;

import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class DozerMapperImpl implements DozerMapper {

    private Mapper mapper;

    public DozerMapperImpl(Mapper mapper) {
        this.mapper = mapper;
    }

    public <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationClass);
    }

    @Override
    public void map(Object source, Object destination) {
        mapper.map(source, destination);
    }

    @Override
    public <T> List<T> mapList(Iterable<?> sources, Class<T> destinationClass) {
        List<T> list = new ArrayList<>();
        for (Object obj : sources) {
            list.add(map(obj, destinationClass));
        }
        return list;
    }

    @Override
    public <T> Page<T> mapPage(Page<?> sourcePage, Class<T> destinationClass, Pageable pageable, int totalSize) {
        List<T> data = mapList(sourcePage.getContent(), destinationClass);
        return new PageImpl<>(data, pageable, totalSize);
    }
}
