import javax.mail.Session
import javax.mail.Message
import javax.mail.Transport
import javax.mail.internet.MimeMessage
import javax.mail.internet.InternetAddress


def descriptor = Jenkins.instance.getDescriptor("hudson.tasks.Mailer")

Session session = descriptor.createSession();
MimeMessage msg = new MimeMessage(session);

InternetAddress fromAddress = new InternetAddress(descriptor.getAdminAddress());

msg.setFrom(fromAddress)

msg.setRecipients(MimeMessage.RecipientType.TO, (InternetAddress[]) [new InternetAddress('tshrikhande99@gmail.com')].toArray());

String charset = descriptor.getCharset();
msg.setSubject("Test", charset);
msg.setText("service is stopped", charset)

Transport transporter = session.getTransport("smtp");
transporter.connect();
transporter.send(msg);
