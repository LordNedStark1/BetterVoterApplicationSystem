package africa.semicolon.repositories;

import africa.semicolon.models.Admin;
import africa.semicolon.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BvasAdminRepositoryTest {
    private final BvasAdminRepository repository = new BvasAdminRepository();
    private Admin admin;

    private Admin savedAdmin;
    @BeforeEach
    void setUp(){
        admin = createAdmin();
        savedAdmin = repository.save(admin);
    }

    private Admin createAdmin() {
        Admin admin = Admin.builder().userInformation(createUserInformation()).build();
        return admin;
    }

    private UserInformation createUserInformation() {
        UserInformation userInformation1 = UserInformation.builder().userName("jibowu").build();
        return userInformation1;
    }

    @Test
    void testSaveMethod(){
        Admin voter1 = repository.save(admin);
        assertNotNull(admin);
        assertEquals(admin.getId(), voter1.getId());
        assertEquals("jibowu", voter1.getUserInformation().getUserName());
    }

    @Test
    void testFindById(){
        Admin Admin1 = repository.save(admin);
        assertEquals(admin, repository.findById(Admin1.getId()));
    }
    @Test
    void testSaveMultipleVoter(){
        Admin secondAdmin = repository.save(createAdmin());
        Admin thirdAdmin = repository.save(createAdmin());
        assertNotNull(thirdAdmin);
        assertNotNull(secondAdmin);
        assertEquals(3, repository.findAll().size());
    }
    @Test
    void deleteVoterById(){
        Admin secondAdmin = repository.save(createAdmin());
        assertEquals(BigInteger.valueOf(2).intValue(), repository.findAll().size());
        repository.deleteById(savedAdmin.getId());
        assertEquals(1, repository.findAll().size());


    }
}
