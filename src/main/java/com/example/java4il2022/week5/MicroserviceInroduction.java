package com.example.java4il2022.week5;

/**
 *  Monolithic project
 *      issues:
 *          1. bugs
 *          2. project size
 *          3. new feature -> deployment
 *          4. performance
 *          5. vertical scaling + horizontal scaling
 *
 *                   load balancer
 *                /        |        \
 *          node1       node2          node3
 *          ..
 *  Microservice
 *                       |
 *                   res1 + res2
 *            /                         \
 *      service1     <  ---  >       service2
 *     node1  node2               node1   node2

 *      pros:
 *          1. fail tolerance
 *          2. easy deployment
 *          3. scalability
 *          4. diff teams work on diff services
 *          ..
 *     what should we do if we want to design microservice:
 *          1. more complex
 *          2. request fail
 *              service1  ->  restful request get exception -> service2
 *              a. retry
 *              b. circuit breaker
 *                      service1   ->  X / O  -> service2
 *                          |                     |
 *                          ----circuit breaker---
 *         3. service boundary
 *         4. global transaction
 *              a. 2PC / 3PC
 *              b. SAGA pattern
 *         5. discovery service
 *              service1 -> restful api request -> service2(node1(ip1), node2(ip2), node3(ip3))
 *                  |                                   |
 *                      -----discovery service--------
 *
 *                     http://service2-name/employees
 *        6. configuration service
 *        7. gateway
 *                             user
 *                              |
 *                           gateway     --->  security
 *                       /      \       \
 *                     s1       s2      s3
 *       10. message queue (kafka , SQS / SNS)
 *              user -> send request -> service
 *
 *              user -> send request -> service  A
 *                                      save message   ->   message queue (server) -> consumer(server) ->
 *                   <- send response <-
 *       11. co-relation id (global unique id)
 *             long number
 *             40 digits   +   5 digits    +   5 digits     +  12 digits
 *             timestamp       machine id      thread id        serial id 0 - ((1 << 12) - 1)
 *       12. performance ..
 *             db - cache
 *       13. scalability
 *             db
 *             docker / ECS / ECR
 *       ...
 *
 *  tomorrow:
 *      spring cloud project
 *      db
 *      cache
 *      message queue
 *      ..
 */
