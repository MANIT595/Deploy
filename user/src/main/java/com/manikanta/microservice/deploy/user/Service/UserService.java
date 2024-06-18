package com.manikanta.microservice.deploy.user.Service;

import com.manikanta.microservice.deploy.user.DTO.UserDTO;
import com.manikanta.microservice.deploy.user.Entity.User;

public interface UserService {
//    UserDTO saveEmployee(UserDTO employeeDto);
//
//    UserDTO getEmployeeById(Long employeeId);

    UserDTO getUser(Long userId) throws Exception;

    void deleteUser(Long userId);

    void addUser(User user);

//    UserResponse getUsers(int pageNo, int pageSize, String pageSortBy, String sortDir);

//    UserDtoOrders getUsersOrders(String userId);
}
