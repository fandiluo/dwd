package io.fandi;

import io.quarkus.scheduler.Scheduled;
import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ExampleScheduler {

    @Inject
    PgPool pgPool; // <-- NullPointerException

    @Scheduled(every = "5s")
    public void foo() {
        RowSet<Row> join = pgPool.query("SELECT 1").toCompletableFuture().join();

    }
}
