package com.brewin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.brewin.service.MainService;
import com.brewin.service.RemoteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMock {

    @MockBean
    private RemoteService remoteService;

    @Autowired
    private MainService mainService;

    @Test
    public void testMainService() {
      // 模拟remoteService的call方法返回angus
      BDDMockito.given(this.remoteService.call()).willReturn("angus");
      mainService.mainService();
    }
}
