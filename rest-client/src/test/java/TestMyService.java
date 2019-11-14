import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.brewin.MyService;
import com.brewin.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestMyService {

    @Autowired
    private MyService myService;
    @Test
    public void testUserTemplate() {
      Person p = myService.useBuilder();
      System.out.println(p.getName() + "===" + p.getAge());
    }
}
