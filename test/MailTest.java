import org.junit.*;

import play.db.jpa.JPABase;
import play.test.*;
import models.*;

public class MailTest extends UnitTest {

    @Test
    public void createMail() {
        User testUser = new User("facebookId").save();
        Template testTemplate = new Template("name", "test mail subject", "body", testUser).save();

        Mail mail = new Mail(testTemplate, testUser);
        mail.save();

        Mail findMail = Mail.findById(mail.id);

        assertEquals(findMail.template.subject, testTemplate.subject);
        assertEquals(findMail.user.facebookId, testUser.facebookId);
    }

}
