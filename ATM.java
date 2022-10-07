import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ATM {

	public void main() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Customer_Details> l = new ArrayList<Customer_Details>();
		l.add(new Customer_Details(101, "Suresh", 2343, 25234));
		l.add(new Customer_Details(102, "Ganesh", 5432, 34123));
		l.add(new Customer_Details(103, "Magesh", 7854, 26100));
		l.add(new Customer_Details(104, "Naresh", 2345, 80000));
		l.add(new Customer_Details(105, "Harish", 1907, 103400));

	    FileOutputStream fo=new FileOutputStream("Details.txt");
		ObjectOutputStream os=new ObjectOutputStream(fo);
		
		os.writeObject(l);
		os.flush();
		os.close();
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Load Cash to ATM\r\n2. Show Customer Details\r\n3. Show ATM Operations\r\n");
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("Details.txt"));
		ArrayList<Customer_Details> ll = new ArrayList<Customer_Details>();

		ll = (ArrayList<Customer_Details>) is.readObject();
		while (true) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Load_cash.LoadingCash();
				System.out.println("Enter m to main menu \nEnter y to countinue \nEnter n to Exit!!");
				String str1 = sc.next();
				if (str1.equals("m")) {
					main();
				} else if (str1.equals("y")) {
					continue;
				} else {
					System.exit(0);
				}
				break;

			case 2:

				System.out.println("AccNO   Name     Pin    Balance");
				for (Customer_Details details : ll) {
					System.out.println(details.getId() + "  |  " + details.getName() + " | " + details.getPin() + " | "
							+ details.getAccBal());
				}
				System.out.println("Enter m to main menu \nEnter y to countinue \nEnter n to Exit!!");
				String str2 = sc.next();
				if (str2.equals("m")) {
					main();
				} else if (str2.equals("y")) {
					continue;
				} else {
					System.exit(0);
				}

				break;

			case 3:
				int nac = 0;
				int npi = 0;
				System.out.println("Enter your Account Number :");
				int Acno = sc.nextInt();
				for (Customer_Details cc : ll) {
					if (Acno == cc.getId()) {
						nac = 0;
						System.out.println("Enter your Pin :");
						int pn = sc.nextInt();

						while (true) {
							System.out.println(
									"\n1. Check Balance\r\n2. Withdraw Money\r\n3. Transfer Money\r\n4. Check ATM Balance");
							
							int val = sc.nextInt();
							switch (val) {
							case 1:
							    Handleprocess.CheckBalance(Acno,pn,ll);
								System.out.println("Enter y to countinue \nEnter n to Exit!!");
								String str3 = sc.next();
								if (str3.equals("y")) {
									continue;
								} else {
									System.exit(0);
								}
								break;

							case 2:
								Load_cash.withdrawAmount(Acno, ll);
								System.out.println("Enter y to countinue \nEnter n to Exit!!");
								String str4 = sc.next();
								if (str4.equals("y")) {
									continue;
								} else {
									System.exit(0);
								}
								break;

							case 3:
								Handleprocess.TransferMoney(Acno, pn, ll);
								System.out.println("Enter y to countinue \nEnter n to Exit!!");
								String str5 = sc.next();
								if (str5.equals("y")) {
									continue;
								} else {
									System.exit(0);
								}
								break;

							case 4:
								Load_cash.ATMBalance();
								System.out.println("Enter y to countinue \nEnter n to Exit!!");
								String str6 = sc.next();
								if (str6.equals("y")) {
									continue;
								} else {
									System.exit(0);
								}
								break;
							}
							break;
						}
					} else {
						nac = 1;
					}
				}

				if (nac == 1) {
					System.out.println("Invalid ACCOUNT NUMBER");
				} else if (npi == 1) {
					System.out.println("Invalid PIN");
				}
				break;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
         ATM a=new ATM();
         a.main();
	}
}
