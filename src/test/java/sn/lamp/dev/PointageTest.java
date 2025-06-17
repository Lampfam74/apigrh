package sn.lamp.dev;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sn.lamp.dev.controller.PointagesController;
import sn.lamp.dev.model.Pointages;
import sn.lamp.dev.service.PointageService;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static java.sql.Date.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class PointageTest {
@InjectMocks
    private PointagesController pointagesController;
@Mock
private PointageService pointageService;
@Before
    public void setup(){
    MockitoAnnotations.openMocks(this);
    LocalDateTime now = LocalDateTime.now();

    // Formater la date et l'heure
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = now.format(formatter);

    // Séparer la date et l'heure
    String[] dateTimeParts = formattedDateTime.split(" ");
    String date = dateTimeParts[0];
    String time = dateTimeParts[1];

    // Afficher la date et l'heure séparément
    System.out.println("Date: " + date);
    System.out.println("Heure: " + time);
    SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");

    // Parser la chaîne en objet java.util.Date puis en java.sql.Date
    Date sqlDate = null;
    Time time1 = null;
    try {
        sqlDate = new Date(sdfdate.parse(date).getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


        time1 = new Time(sdf.parse(time).getTime());
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    Pointages p=new Pointages("entree",sqlDate ,time1,"qwertyuiofghjkknvbcgfdghjkhgfdg");
    System.out.println("objet=>"+p.getToken());
//    String pointagesStringMap = pointagesController.addPointages(p);
//    System.out.println("response: " + pointagesStringMap);
//   List<Pointages> l=pointagesController.getAll();
//   assertThat(l,is(not(null)));
   }
   @Test
    public void addPointageTest(){

//       LocalDateTime now = LocalDateTime.now();
//
//       // Formater la date et l'heure
//       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//       String formattedDateTime = now.format(formatter);
//
//       // Séparer la date et l'heure
//       String[] dateTimeParts = formattedDateTime.split(" ");
//       String date = dateTimeParts[0];
//       String time = dateTimeParts[1];
//
//       // Afficher la date et l'heure séparément
//       System.out.println("Date: " + date);
//       System.out.println("Heure: " + time);
//       SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//
//       // Parser la chaîne en objet java.util.Date puis en java.sql.Date
//       Date sqlDate = null;
//       Time time1 = null;
//       try {
//           sqlDate = new Date(sdfdate.parse(date).getTime());
//
//           SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//
//
//           time1 = new Time(sdf.parse(time).getTime());
//       } catch (ParseException e) {
//           throw new RuntimeException(e);
//       }
//       Pointages p=new Pointages("entree",sqlDate ,time1,"qwertyuiofghjkknvbcgfdghjkhgfdg");
//      String pointagesStringMap = pointagesController.addPointages(p);
   }

}
