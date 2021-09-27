package com.test.beeline.services.impl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.test.beeline.dto.UserDto;
import com.test.beeline.domain.User;
import com.test.beeline.mappers.UserMapper;
import com.test.beeline.repositories.UserRepository;
import com.test.beeline.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void create(InputStream file) throws IOException {
        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper mapper = new CsvMapper();
        MappingIterator<UserDto> readValues = mapper.readerFor(User.class).with(bootstrapSchema).readValues(file);
        List<UserDto> allValues = readValues.readAll();

        List<User> users = allValues.stream()
                .map(this.mapper::mapToEntity)
                .map(this.repository::save)
                .collect(Collectors.toList());


    }

//    public List<User> readCsvFile(MultipartFile file) throws FileNotFoundException {
//        FileReader reader = new FileReader(file);
//        CsvToBean<Ship> csvToBean = new CsvToBeanBuilder<Ship>(reader)
//                .withType(Ship.class)
//                .build();
//        return csvToBean.parse();
}
