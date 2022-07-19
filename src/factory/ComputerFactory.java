package factory;

// 가장 중요한 팩토리 클래스를 만들어 보자
public class ComputerFactory {
	/**
	 * 
	 * 1. static 메서드를 활용한다.
	 * 2. type 값에 따라서 객체를 생성할 수 있게 설계한다.
	 * 
	 */
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		
		// 문자열 먼저 비교하면 NPE에서 비교적 안전할 수 있음
		if("PC".equals(type)) {
			return new PC(ram, hdd, cpu);
		} else if("NoteBook".equalsIgnoreCase(type)) { // equalsIgnoreCase - 대소문자 무시
			return new NoteBook(ram, hdd, cpu);
		}
		
		return null;
	}
}
