package TestServices;

import authentication.authentication.modules.user.UserRepository;
import authentication.authentication.modules.user.entities.Role;
import authentication.authentication.modules.user.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ActiveProfiles("local")
@ExtendWith(SpringExtension.class)
public class TestCreateUserDeviceV1 {


    @InjectMocks
    private TestCreateUserDeviceV1 service;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user1 = new User();
        user1.setUsername("teste");
        user1.setPassword("teste");
        user1.setName("testeUser");

        Role role = new Role();
        role.setName("testeRole");

    }


    @Test
    public void createUserDeviceIsOK() {
        User user = new User();
        user.setUsername("teste");
        user.setPassword("teste");
        user.setName("testeUser");

        Role role = new Role();
        role.setName("testeRole");

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User userResponse = service.createUserDevice(user);

        Assertions.assertEquals(userResponse.getUsername(), user.getUsername());
        Assertions.assertEquals(userResponse.getPassword(), user.getPassword());
        Assertions.assertEquals(userResponse.getName(), user.getName());
        Assertions.assertEquals(userResponse.getRoles().get(0).getName(), user.getRoles().get(0).getName());
    }

    private User createUserDevice(User user) {
        User userResponse = userRepository.save(user);
        return userResponse;

    }

    @Test
    public void deveRetornarException() {

        doThrow(RuntimeException.class)
                .when(userRepository)
                .findByUsername(Mockito.anyString());

        assertThrows(RuntimeException.class, () ->
            service.createUserDevice(new User()));
    }


}