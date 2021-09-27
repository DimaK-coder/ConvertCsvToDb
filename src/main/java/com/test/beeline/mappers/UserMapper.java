package com.test.beeline.mappers;

import com.test.beeline.dto.UserDto;
import com.test.beeline.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto>{
}
