package notHaveWebXml.data.impl;

import notHaveWebXml.data.SpittleRepository;
import notHaveWebXml.pojo.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittle() {
        List<Spittle> list = new ArrayList<>();
        list.add(new Spittle(1L, "1"));
        list.add(new Spittle(2L, "2"));
        list.add(new Spittle(3L, "3"));
        return list;
    }
}
