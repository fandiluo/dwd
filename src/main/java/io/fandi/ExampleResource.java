package io.fandi;


import io.quarkus.vertx.web.Route;
import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class ExampleResource {

    @Inject
    PgPool pgPool;


    @Route(path = "/hello", methods = HttpMethod.GET)
    public void q(RoutingContext ctx) {
        RowSet<Row> join = pgPool.query("SELECT 1").toCompletableFuture().join();
        ctx.response().end("OK");
    }


}