package com.manikanta.microservice.deploy.user.Service.Implementation;

import com.manikanta.microservice.deploy.user.DTO.UserDTO;
import com.manikanta.microservice.deploy.user.Entity.User;
import com.manikanta.microservice.deploy.user.Exception.EmailAlreadyFoundException;
import com.manikanta.microservice.deploy.user.Exception.UserNotFoundException;
import com.manikanta.microservice.deploy.user.Mapper.AutoUserMapper;
import com.manikanta.microservice.deploy.user.Repository.UserRepository;
import com.manikanta.microservice.deploy.user.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);

//    @Autowired
//    private RestTemplate  restTemplate;

//    @Autowired
//            private WebClient webClient;

//    @Autowired
//            private FeignAPIClient feignAPIClient;

//    @Autowired
//    private ModelMapper mapper;

    @Override
    public UserDTO getUser(Long userId){
        logger.info("entered into get user by id method");
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("No User Found with this userId: "+userId));
        return AutoUserMapper.MAPPER.mapToDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        System.out.println("Deleted");
    }

    @Override
    public void addUser(User user) {
        User userOne = userRepository.findByEmail(user.getEmail());
        if(userOne != null){
            throw new EmailAlreadyFoundException("Email Already found in database");
        }
        userRepository.save(user);
        System.out.println("saved to db");
    }

}
