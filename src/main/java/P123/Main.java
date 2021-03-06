package P123;

import java.sql.SQLException;

public class Main {
	private static StudentOracleDaoImpl studentdao = new StudentOracleDaoImpl();
	private static KlasOracleDaoImpl klasdao = new KlasOracleDaoImpl();
	private static VolgtOracleDaoImpl volgtdao = new VolgtOracleDaoImpl();
	private static VakOracleDaoImpl vakdao = new VakOracleDaoImpl();

	public static void main(String[] arg) throws SQLException {
				
		Klas klas1 = new Klas("V1A", "Meneer Janssen", 2019);
		Student student1 = new Student(00001, "Dennis de Braan", null, "V1A");
		Vak vak1 = new Vak("PROG", "Programmeren", 5);
		Volgt volgt1 = new Volgt(00001, "PROG");
		
		Klas klas2 = new Klas("V1A", "Wilma Petersen", 2020);
		Student student2 = new Student(00001, "Jelle de Snelle", null, "V1A");
		Vak vak2 = new Vak("WAC", "Web Application Construction", 5);
		//Testen of save() werkt
		System.out.println("save() test:");
		
		System.out.println("save klas " + klasdao.save(klas1));
		System.out.println("save student " + studentdao.save(student1));
		System.out.println("save vak " + vakdao.save(vak1));
		System.out.println("save volgt " + volgtdao.save(volgt1));
		
		//Testen of delete() werkt
		System.out.println("delete() test:");
		System.out.println("delete volgt " + volgtdao.delete(volgt1));
		System.out.println("delete vak " + vakdao.delete(vak1));
		System.out.println("delete student " + studentdao.delete(student1));
		System.out.println("delete klas " + klasdao.delete(klas1));
		
		//Testen of update() werkt
		System.out.println("update() test:");
		System.out.println("delete vak " + vakdao.update(vak2));
		System.out.println("delete student " + studentdao.update(student2));
		System.out.println("delete klas " + klasdao.update(klas2));
		
		//Herstelt oude waarden om later opnieuw update() te kunnen testen
		
	}
}