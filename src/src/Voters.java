package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Voters {

	public static HashSet<Voter> voters = new HashSet<>();

	public static void main(String[] args) throws IOException {

		while (true) {
			System.out.println();
			System.out.println("1. Add New Voter");
			System.out.println("2. List All Voters");
			System.out.println("3. Find a Voter By Name");
			System.out.println("4. Get information about specific voter");
			System.out.println("5. Exit");
			System.out.println();
			Scanner scanner = new Scanner(System.in);

			int chosen = scanner.nextInt();

			switch (chosen) {
			case 1:
				System.out.print("National ID Number: ");
				int idNum = scanner.nextInt();
				System.out.print("\nName: ");
				String name = scanner.next();
				System.out.print("\nMale Relative: ");
				String maleRelative = scanner.next();
				System.out.print("\nAge: ");
				int age = scanner.nextInt();
				System.out.print("\nAddress: ");
				String address = scanner.next();
				System.out.print("\nProvince: ");
				String province = scanner.next();
				System.out.println("");
				Voter voter = new Voter(idNum, name, maleRelative, age, address, province);
				voters.add(voter);
				FileWriter fileWriter = new FileWriter("C:\\Users\\YourPcName\\Desktop\\voters.txt", true);
				fileWriter.append("\n").append(voter.toString());
				fileWriter.flush();
				fileWriter.close();
				break;
			case 2:
				for (Voter v : voters) {
					System.out.println(v);
				}
				break;
			case 3:
				System.out.print("Name: ");
				Scanner ss = new Scanner(System.in);
				String n = ss.nextLine();
				System.out.println();
				for (Voter v : voters) {
					if (v.name.contains(n)) {
						System.out.println(v);
						break;
					}
				}
				break;
			case 4:
				System.out.print("Id: ");
				Scanner nn = new Scanner(System.in);
				int s = nn.nextInt();
				System.out.println();
				for (Voter v : voters) {
					if (v.nationalIdNumber == s) {
						System.out.println(v);
					}
				}
				break;
			case 5:
				System.exit(0);
				break;
			default:
			}

		}
	}

	static class Voter {
		public int nationalIdNumber;
		public String name;
		public String maleRelativeName;
		public int age;
		public String address;
		public String province;

		public Voter(int nationalIdNumber, String name, String maleRelativeName, int age, String address,
				String province) {
			this.nationalIdNumber = nationalIdNumber;
			this.name = name;
			this.maleRelativeName = maleRelativeName;
			this.age = age;
			this.address = address;
			this.province = province;
		}

		@Override
		public String toString() {
			return "Id: " + nationalIdNumber + "  Name: " + name + "  Male Relative: " + maleRelativeName + "  Age: "
					+ age + "  Address: " + address + "  Province: " + province;
		}
	}
}
