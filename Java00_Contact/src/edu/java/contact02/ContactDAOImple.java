package edu.java.contact02;

public class ContactDAOImple implements ContactDAO {
	
		private static ContactDAOImple instance = null;
		
		private ContactDAOImple() {}
		
		public static ContactDAOImple getInstance() {
			if(instance == null) {
				instance = new ContactDAOImple();
			}
			return instance;
		}
		
		private final int MAX = 100; 
		private ContactVO[] list = new ContactVO[MAX]; 
		private int count; 
		
		@Override
		public int insert(ContactVO vo) {
			list[count] = vo;
			count++;
			return 1;
		}

		@Override
		public ContactVO[] selectAll() {
			return list;
		}

		@Override
		public ContactVO select(int index) {
			return list[index];
		}

		@Override
		public int update(int index, ContactVO vo) {
			list[index].setName(vo.getName());
			list[index].setEmail(vo.getEmail());
			list[index].setPhone(vo.getPhone());
			return 1;
		}
}
