package com.ctrip.xpipe.redis.checker.alert.decorator;

import com.ctrip.xpipe.redis.checker.AbstractCheckerIntegrationTest;
import com.ctrip.xpipe.redis.checker.alert.ALERT_TYPE;
import com.ctrip.xpipe.redis.checker.alert.AlertEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chen.zhu
 * <p>
 * Oct 19, 2017
 */
public class AlertMessageDecoratorTest extends AbstractCheckerIntegrationTest {

    @Autowired
    private AlertMessageDecorator decorator;

    @Test
    public void getTemplateName() throws Exception {
        Assert.assertEquals("RedisAlertTemplate.vm", decorator.getTemplateName());
    }

    @Test
    public void generateTitle() throws Exception {
        Assert.assertTrue(decorator
                .generateTitle(new AlertEntity(null, null, null, null, null, ALERT_TYPE.CLIENT_INCONSIS))
                .contains("[XPipe 报警]"));
    }

}