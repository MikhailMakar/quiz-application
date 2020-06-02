package com.quiz.util;

import com.quiz.dto.ListForDto;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public class GenericModelMapper {

    private GenericModelMapper() {}

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T, E> T convertToClass(E entity, Class<T> type) {
        return modelMapper.map(entity, type);
    }

    public static <T, E> ListForDto<T> convertList(ListForDto<E> list, Class<T> type) {
        return new ListForDto<>(list.getResults()
                .stream()
                .map(entity -> modelMapper.map(entity, type))
                .collect(Collectors.toList()));
    }
}
