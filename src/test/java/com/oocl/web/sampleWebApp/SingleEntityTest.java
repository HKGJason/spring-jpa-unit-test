package com.oocl.web.sampleWebApp;

import com.oocl.web.sampleWebApp.SingleEntity;
import com.oocl.web.sampleWebApp.SingleEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SingleEntityTest {

    @Autowired
    private SingleEntityRepository singleEntityRepository;

    @Test
    public void singe_entity_fetch_test(){
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.setId(1L);
        singleEntity.setName("test");

        singleEntityRepository.save(singleEntity);
        SingleEntity fetched = singleEntityRepository.getOne(1L);
        assertEquals("test", fetched.getName());
    }
}
