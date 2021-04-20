package com.ctrip.xpipe.redis.ctrip.integratedtest.console.migration.mock;

import com.ctrip.xpipe.concurrent.AbstractExceptionLogTask;
import com.ctrip.xpipe.redis.console.migration.model.MigrationCluster;
import com.ctrip.xpipe.redis.console.migration.status.migration.MigrationMigratingState;

import java.util.concurrent.TimeUnit;

/**
 * @author lishanglin
 * date 2021/3/29
 */
public class MockMigrationMigratingState extends MigrationMigratingState {

    public MockMigrationMigratingState(MigrationCluster holder) {
        super(holder);
    }

    @Override
    public void doAction() {
        executors.execute(new AbstractExceptionLogTask() {
            @Override
            public void doRun() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    logger.info("[doAction] sleep fail", e);
                }

                updateAndProcess(new MockMigrationPublishState(getHolder()));
            }
        });
    }

}
