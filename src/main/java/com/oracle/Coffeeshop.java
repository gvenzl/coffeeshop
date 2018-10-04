package com.oracle;

public class Coffeeshop {
	
	public static void main(String[] args) throws Exception {
		
		Integer threads=1;
		Integer waitSec=2;
		String  restURL="";
		String  jdbc=null;
		String  username="";
		String  password="";
		String  file="";
		String  credFile="";
		boolean historicData = false;
		
		if (args.length == 0) {
			printHelp();
			System.exit(1);
		}
		
		for (int i=0; i<args.length; i++) {
			if (args[i].equalsIgnoreCase("--threads")) {
				threads = Integer.valueOf(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--wait")) {
				waitSec = Integer.valueOf(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--url")) {
				restURL = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--jdbc")) {
				jdbc = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--user")) {
				username = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--pwd")) {
				password = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--file")) {
				file = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--historic")) {
				historicData = true;
			}
			else if (args[i].equalsIgnoreCase("--creds")) {
				credFile = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--help") ||
					args[i].equalsIgnoreCase("-h") ||
					args[i].equalsIgnoreCase("-help")) {
				printHelp();
				System.exit(0);
			}
			else {
				printHelp();
				System.exit(1);
			}
		}

		new Coffeeshop().run(threads, waitSec, restURL, jdbc, username, password, file, historicData, credFile);
	}
	
	public static void printHelp() {
		System.out.println("java -jar coffeeshop.jar --threads <n> --wait <n>sec --url <REST url> --jdbc <JDBC url> --historic");
		System.out.println("--threads <n>\t\tThe amount of concurrent sessions that should be used.");
		System.out.println("--wait <n>\t\tThe amount of seconds that the program should pause between requests.");
		System.out.println("--url <REST URL>\tThe REST URL to use for the rest call.");
		System.out.println("--jdbc <JDBC url>\tThe JDBC connection string to use for the inserts.");
		System.out.println("--user <username>\tThe JDBC user, only applicable when run with jdbc.");
		System.out.println("--pwd <password>\tThe JDBC password, only applicable with jdbc.");
		System.out.println("--file <file name>\tThe file name for the data.");
		System.out.println("--historic\t\tLoads into historic table rather than active table");
		System.out.println("--creds <file path>\tPath to Exadata Express credential file (only needed for JDBC access)");
	}

	public void run(Integer threads, Integer waitSec, String restURL, String jdbc, String username, String password, String file, boolean historicData, String credFile) {
		Generator generator = new Generator(restURL, threads, waitSec, jdbc, username, password, file, false, historicData, credFile);
		generator.run();
	}

}
