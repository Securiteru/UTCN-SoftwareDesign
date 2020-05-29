package presentation_layer.validation;

import jdk.nashorn.internal.ir.CallNode;

import javax.swing.*;

public class AdminValidation {
	public static boolean validateInsertAccount(String client_id, String account_type, String amount, String currency_code, String account_status){
		try {
			Integer.parseInt(client_id);
			Integer.parseInt(account_status);
			Float.parseFloat(amount);
			System.out.println(" ALL INPUTS CORRECT");
		}catch(Exception e){
			return false;
		}
		if((account_type.equals("Depozit") || account_type.equals("Credit")) && (currency_code.equals("EUR") || currency_code.equals("RON"))){
			System.out.println(" DEPOZIT OR CREDIT ");
			System.out.println("EUR  OR RON ");
			return true;
		}
		return false;
	}

	public static boolean validateUpdateAccount(String account_id, String client_id, String account_type, String amount, String currency_code, String account_status){
		try {
			Integer.parseInt(account_id);
			Integer.parseInt(client_id);
			Integer.parseInt(account_status);
			Float.parseFloat(amount);
		}catch(Exception e){
			return false;
		}
		if((account_type.equals("Depozit") || account_type.equals("Credit")) && (currency_code.equals("EUR") || currency_code.equals("RON"))){
			System.out.println(" DEPOZIT OR CREDIT ");
			System.out.println("EUR  OR RON ");
			return true;
		}
		return false;
	}

	public static boolean validateDeleteAccount(String account_id){
		try {
			Integer.parseInt(account_id);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public static boolean validateInsertClient(String client_id,String login_id){
		System.out.println("IN VALIDATE INSERT CLIENT: client_id"+client_id+" login id: "+login_id);
		try {
			Integer.parseInt(client_id);
			Integer.parseInt(login_id);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean validateUpdateClient(String client_id,String login_id){
		System.out.println("IN VALIDATE UPDATE CLIENT: client_id"+client_id+" login id: "+login_id);
		try {
			Integer.parseInt(client_id);
			Integer.parseInt(login_id);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public static boolean validateDeleteClient(String client_id){
		try {
			Integer.parseInt(client_id);
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
