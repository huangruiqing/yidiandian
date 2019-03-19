package hrq.multidatasorce.datasourcemulti2.dao;

import hrq.multidatasorce.datasourcemulti2.dao.mapper.master.TestMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestMasterDao
 * @Description
 * @Author huangrq
 * @Date 2019/3/18 16:22
 */
@Component
public class TestMasterDao {
    @Autowired
    private TestMasterMapper testMasterMapper;

    public int getCount(){
        return testMasterMapper.getCount();
    }
    public int save(){
        return testMasterMapper.save();
    }
}
