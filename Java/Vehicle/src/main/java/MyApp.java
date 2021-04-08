import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyApp {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();
	Transaction txn= session.beginTransaction();
	
	Vehicle vehicle= new Vehicle();
	vehicle.setVehicleName("Vanilla Vehicle");
	session.save(vehicle);

//	
	TwoWheeler twoWheeler1=new TwoWheeler();
	twoWheeler1.setVehicleName("Royal Enfield");
	twoWheeler1.setTwoWheelerModel("Bullet007");
	session.save(twoWheeler1);

	
	FourWheeler fourWheeler1 =new FourWheeler();
	fourWheeler1.setVehicleName("Maruti Suzuki");
	fourWheeler1.setFourWheelerModel("Ciaz");
	session.save(fourWheeler1);

	
	txn.commit();
	session.close();
}
}
