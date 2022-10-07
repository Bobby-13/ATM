import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Handleprocess {

	static Scanner sc = new Scanner(System.in);

	public static void CheckBalance(int Accno, int pin, ArrayList<Customer_Details> ll) {

		for (Customer_Details cc : ll) {
			if (Accno == cc.getId()) {
				System.out.println("Balance :" + cc.getAccBal());
				break;
			}
		}
	}

	public static void TransferMoney(int Accno, int pin, ArrayList<Customer_Details> l) throws IOException {
		System.out.println("Enter the Receiver Accno :");
		int An = sc.nextInt();

		System.out.println("Enter the Amount to Transfer :");
		int Amount = sc.nextInt();

		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getId() == Accno) {
				int minus = l.get(i).getAccBal() - Amount;
				l.get(i).setAccBal(minus);
			}
			if (l.get(i).getId() == An) {
				int val = l.get(i).getAccBal() + Amount;
				int minus = l.get(i).getAccBal() - Amount;
				l.get(i).setAccBal(val);
			}
		}
		FileOutputStream fo = new FileOutputStream("Details.txt");
		ObjectOutputStream os = new ObjectOutputStream(fo);
		os.writeObject(l);
		System.out.println("Successfully Transfered");
	}

}
