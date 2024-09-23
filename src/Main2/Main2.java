package Main2;
import java.util.ArrayList;

import Menu.Menu;
import MenuDAO.MenuDAO;
import MenuDAOimpl.MenuDAOimpl;

public class Main2 {
	public static void main(String[] args) {
			// TODO Auto-generated method stub

//			Menu r=new Menu(102,"Margherita Pizza","Classic pizza with tomatoes and mozzarella",120,true,"E:\\test\\download (2).jpeg");
			MenuDAO rdao=new MenuDAOimpl();
//			int status=rdao.insertMenu(r);
//			System.out.println(status+" row affected");
			
			
			
//			ArrayList<Menu> users=(ArrayList) rdao.getAllMenu(102);
//			for(Menu u:users)
//			{
//				System.out.println(u);
//			}
			
			
//			Menu res=rdao.getMenuById(2);
//			System.out.println(res);
			
			
//			int status=	rdao.deleteMenuById(1);
//			System.out.println(status+" row affected");
			
			
			int status=rdao.updateMenuById(2, false);
			System.out.println(status+" row affected");
		}
		

	}


