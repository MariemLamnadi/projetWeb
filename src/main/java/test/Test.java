package test;
import beans.Salle;
import service.SalleService;
public class Test {

public static void main(String[] args) {
		SalleService ss= new SalleService();
		for(Salle s :ss.findAll()) {
			System.out.println(s.getCode());
		}
	}
}
