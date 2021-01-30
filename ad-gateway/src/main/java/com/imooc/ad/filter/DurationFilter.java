package com.imooc.ad.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Jiusen Guo
 * @date 2021/1/31 2:44
 *
 *  此过滤器功能为计算请求完成时间
 */
@Component
@Slf4j
public class DurationFilter implements GlobalFilter, Ordered
{

    private static final String REQUEST_TIME_BEGIN = "elapsedTimeBegin";  //请求到来时的时间

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());   //pre
        return chain.filter(exchange).then(    //post
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    ServerHttpRequest request = exchange.getRequest();
                    String uri = request.getURI().toString();   //请求URI
                    if (startTime != null) {
                        Long duration = System.currentTimeMillis() - startTime;   //时间差
                        log.info(" --- uri: " + uri + "duration: " + duration/100 + "ms");
                    }
                })
        );
    }

    /*
     *过滤器存在优先级，order越大，优先级越低
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
