package notHaveWebXml.data;

import notHaveWebXml.pojo.Spittle;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittle();
}
