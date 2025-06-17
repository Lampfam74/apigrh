package sn.lamp.dev;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import sn.lamp.dev.model.TypeContrat;
import sn.lamp.dev.repository.TypeContratRepository;
import sn.lamp.dev.service.TypeContratService;
@DataJpaTest
public class TypeContratTest {

    @Autowired
    private TypeContratRepository typeContratRepository;
    @Mock
    private TypeContratService typeContratService;
    TypeContrat typeContrat;
    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
//        typeContratRepository=new T;
         typeContrat=new TypeContrat("CDI","contrat a durer indetermine");
         
    }
    @Test
    public void FindAllTest(){
        System.out.print("FindAllTest start");
        typeContratService.save(typeContrat);
        List<TypeContrat> c=typeContratService.getAll();
//                new TypeContrat("CDI","contrat a durer indetermine");
//
//        Optional<TypeContrat> ty =typeContratRepository.findById(1L);
//        assertThat(c, is(not(null)));
        assertThat(c.isEmpty(), is(not(false)));

    }
}
