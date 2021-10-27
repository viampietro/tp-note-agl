package fr.umfds.agl.terproject;
import java.io.File;
import java.io.IOException;

//import com.calendarfx.model.Calendar;
//import com.calendarfx.model.Calendar.Style;
//import com.calendarfx.model.CalendarSource;
//import com.calendarfx.view.CalendarView;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import net.fortuna.ical4j.model.component.VEvent;


/**
 * Hello world!
 *
 */
public class App //extends Application
{


//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//	CalendarView calendarView = new CalendarView();
//
//	Calendar birthdays = new Calendar("Birthdays");
//	Calendar holidays = new Calendar("Holidays");
//	Calendar soutenances =new Calendar("Soutenances");
//	soutenances.setStyle(Style.STYLE3);
//
//	Calendar TERM1 = ICalRepository.createWebCalendar("https://calendar.google.com/calendar/ical/1cf1lhevp68ji20m3d069stvb8%40group.calendar.google.com/public/basic.ics", "TER M1", Style.STYLE5, ICalRepository.getCommunityCalendarSource());
//	ICalCalendar perso = ICalRepository.createWebCalendar("https://calendar.google.com/calendar/ical/gptooms8i44op1hvsto3rm1sss%40group.calendar.google.com/public/basic.ics", "PERSO", Style.STYLE5, ICalRepository.getCommunityCalendarSource());
//	holidays.setStyle(Style.STYLE2);
//
//	CalendarSource myCalendarSource = new CalendarSource("My Calendars");
//	myCalendarSource.getCalendars().addAll(birthdays, perso, soutenances, TERM1);
//	Temporal start =java.time.LocalDateTime.of(2021, 06, 11, 18, 0,0);
//	System.out.println(start);
//	Temporal stop=java.time.LocalDateTime.of(2021, 06, 11, 19, 0,0);
//	VEvent ev=new VEvent(start, stop, "coucou");
//	ICalCalendarEntry ajout=new ICalCalendarEntry(ev);
//	perso.addEntry(ajout);
//
//
//	calendarView.getCalendarSources().addAll(myCalendarSource);
//	calendarView.setRequestedTime(LocalTime.now());
//
//	Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
//		@Override
//		public void run() {
//		    while (true) {
//			Platform.runLater(() -> {
//				calendarView.setToday(LocalDate.now());
//				calendarView.setTime(LocalTime.now());
//			    });
//
//			try {
//			    // update every 10 seconds
//			    sleep(10000);
//			} catch (InterruptedException e) {
//			    e.printStackTrace();
//			}
//
//		    }
//		};
//	    };
//
//	updateTimeThread.setPriority(Thread.MIN_PRIORITY);
//	updateTimeThread.setDaemon(true);
//	updateTimeThread.start();
//
//	Scene scene = new Scene(calendarView);
//	primaryStage.setTitle("Calendar");
//	primaryStage.setScene(scene);
//	primaryStage.setWidth(1300);
//	primaryStage.setHeight(1000);
//	primaryStage.centerOnScreen();
//	primaryStage.show();
//    }

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	//launch(args);

	ObjectMapper objectMapper = new ObjectMapper();
	Groupe g = new Groupe("G1");
	Groupe g2 = new Groupe("G2");
	g.setSujetAffecté(new Sujet(null, "Sujet1"));
	objectMapper.writeValue(new File("target/g1.json"), g);

	Groupe gbis = objectMapper.readValue(new File("target/g1.json"), Groupe.class);
	System.out.println(gbis.getNom());


	//----------------------------------------
	// avec serialiseur ad hoc
	ObjectMapper mapper = new ObjectMapper();
	SimpleModule module = new SimpleModule("GroupeSerializer", new Version(1, 0, 0, null, null, null));
	module.addSerializer(Groupe.class, new GroupeSerializer());
	module.addDeserializer(Groupe.class, new GroupeDeserializer());
	mapper.registerModule(module);

	mapper.writeValue(new File("target/g1custom.json"), g);

	Groupe gter=mapper.readValue(new File("target/g1custom.json"), Groupe.class);
	System.out.println(gter.getSujetAffecté());
	System.out.println(gter.getNom());

	GestionTER gt=GestionTER.getInstance();
	gt.init();
	gt.serializeGroupes();
	gt.importGroupes();
	System.out.println(gt);
	
    }
}


