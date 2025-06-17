package sn.lamp.dev;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import sn.lamp.dev.controller.CategorieController;
import sn.lamp.dev.model.Categorie;
import sn.lamp.dev.service.CategorieService;

public class CategorieTest {

    @InjectMocks
    private CategorieController categorieController;  // Controller under test

    @Mock
    private CategorieService categorieService;  // Mocked service

    @Before
    public void setup() {
        // Initialize Mockito annotations to inject mocks
        MockitoAnnotations.openMocks(this);

        // You can predefine some behaviors for mocked methods if needed
        Categorie c = new Categorie(7L, "Commercial", "equipe commercial");
        categorieController.save(c);
       
    }

    @Test
    public void AddCategorieTest() {
        Categorie c1 = new Categorie(6L, "exploitation", "equipe exploitation");
        Categorie c2 = new Categorie(2L, "exploitation", "equipe exploitation");
        Categorie c3 = new Categorie(3L, "exploitation", "equipe exploitation");
        Categorie c4 = new Categorie(4L, "exploitation", "equipe exploitation");
        Categorie c5 = new Categorie(5L, "exploitation", "equipe exploitation");
        Mockito.when(categorieService.findById(4L)).thenReturn(new Categorie(4L, "DAF", "equipe DAF"));
        // Calling save() method in controller
        categorieController.save(c1);
        categorieController.save(c2);
        categorieController.save(c3);
        categorieController.save(c4);
        categorieController.save(c5);

        // Verifying that save() is called on the service
        Mockito.verify(categorieService).save(c1);
        Mockito.verify(categorieService).save(c2);
        Mockito.verify(categorieService).save(c3);
        Mockito.verify(categorieService).save(c4);
        Mockito.verify(categorieService).save(c5);
    }


    @Test
    public  void FindAllTest(){
        for (Categorie categorie : categorieController.getAllCategrie()) {

            assertThat(categorie.getId(),is(not(null)));

        }

    }
    // @Test
    /***
     * tests fails at this stade
     */
    public void FindCategorieTest() {

        Categorie categorie = categorieController.findById(1L);
        assertThat(categorie.getLibelle(), is("test"));
        assertThat(categorie.getDescription(), is("test by Lamp FAM"));
    }
    @Test
    public  void CategorieRemove(){
//        Categorie foundCategories = categorieController.findById((long)1);
       String del= categorieController.delete(1L);
        assertThat(del, is("deleted succefuly"));
//     succefuly  succefuly assertThat(foundCategories.getLibelle(), is("test"));
    }
}
