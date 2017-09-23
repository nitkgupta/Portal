package mails;

public class SendMailSSL {
	public static void main(String[] args) {
		try {
			// from,password,to,subject,message
			Mailer mail = new Mailer();
			mail.send("javammu@gmail.com", "dellintel", "anurag21j@gmail.com", "Women Harrasmant", "case id ?");

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}