//package sn.lamp.dev;
//
//import java.sql.Date;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.not;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import sn.lamp.dev.controller.ContratController;
//import sn.lamp.dev.model.Contrat;
//import sn.lamp.dev.service.ContratService;
//
//public class ContratTest {
//
//    @InjectMocks
//    private ContratController contratController;
//     @Mock
//     private ContratService contratService;
//
//    /**
//     * @throws Exception
//     */
//    @Before
//    public void setup(){
//        MockitoAnnotations.openMocks(this);
//       List<Contrat> contrats=contratController.getAll();
//        assertThat(contrats,is(not(null)));
//    }
//
//     @Test
//    public void AddContratTest() {
//    	 Contrat contrat1;
//    	// Créer une date à partir d'un timestamp
//    	 Date dateDebut = new Date(1672531200000L);  // 2023-10-10
//    	 Date dateFin = new Date(1728518400000L);    // 2024-10-10
//
//    	 contrat1 = new Contrat(
//    	     "Informaticien",
//    	     "1",
//    	     "1",
//    	     "1",
//    	     10000000.0,
//    	     dateDebut,  // Date début basée sur un timestamp
//    	     dateFin     // Date fin basée sur un timestamp
//    	 );
//    	 Contrat c=contratController.save(contrat1);
//
//        // Test pour vérifier que le contrat a bien été ajouté
////        Contrat contrat = contratController.findById(1L) ;
//        assertThat(c,is(not(null))); // Vérifie que le contrat existe
//    }
//    public void removeTest(){
//      assertNotNull(contratController.removeById(1L));
//    }
//}
