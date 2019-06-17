import com.alibaba.fastjson.JSON;
import com.tensquare.gathering.GatheringApplication;
import com.tensquare.gathering.dao.GatheringRespository;
import com.tensquare.gathering.po.Gathering;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GatheringApplication.class)
public class Test {

    @Autowired
    private GatheringRespository gatheringRespository;

    @org.junit.Test
    public void getGathering() {
        Gathering gathering = gatheringRespository.findById("1").orElse(null);
        System.out.println(JSON.toJSONString(gathering));
    }
}
