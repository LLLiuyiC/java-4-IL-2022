package com.example.java4il2022.week4;

/**
 *   0.0.0.0  256.256.256.256
 *   1. www.google.com  <->  DNS server (get destination ip)
 *   2. build connection(Source IP + Source Port, Destination IP + Destination Port)
 *       mac address
 *      client(private ip + port)  ->  NAT(public ip + port)   <->    server(ip + 8080)
 *
 *   3.
 *      A   Application Layer     HTTP
 *      P   Presentation Layer    SSL
 *      S   Session Layer
 *      T   Transport Layer    TCP / UDP    [TCP Header][Data]
 *      N   Network Layer      IP         [IP Header][TCP Header][Data]
 *      D   Data Link Layer    Ethernet
 *      P   Physical Layer     Cable
 *
 *      TCP
 *          open connection
 *          Seq_ID        ACK
 *          client  ->  server
 *          client  <-  server
 *          client  ->  server
 *
 *          idx = 5, data size = 10
 *          client -> server
 *          client <- server ack
 *
 *          client <- server
 *          client -> server
 *
 *          close connection
 *
 *      HTTP
 *          client -> request -> server
 *          client <- response <- server
 *      WebSocket
 *
 *  4.  HTTP
 *          1. TCP/IP
 *          2. url
 *          4. http method :
 *              get => get data
 *              post => create resource
 *              put => update whole resource
 *              patch => update partial resource
 *              delete => delete resource
 *
 *              idempotent
 *          5. header
 *              Content-type : json / xml /.. to server
 *              Accept : json / xml / ..  from server
 *
 *
 *  5. when server receives request
 *          1. Socket build connection
 *          2. assign connection to threads / event loop
 *             Tomcat(ThreadPool)
 *                ThreadPool max 500 Threads
 *             Netty(event loop + thread pool)
 *          3.  servlet
 *              old implementation
 *              EmployeeServlet {
 *                  get();
 *                  post();
 *              }
 *              configure servlet with url
 *              /employees <=> EmployeeServlet
 *          4. new implementation => Spring MVC
 *              /* => dispatcher servlet  =>  handler mapping => Controller class
 *                          |
 *                   HttpMessageConverter(old implementation : view resolver)
 *                         |
 *                      Jackson
 *                         |
 *                       JSON
 *
 *  6. session vs cookie
 *
 *      1st request
 *     client -> request -> server
 *                          generate session_id
 *     client <- response <- server
 *      2nd request
 *     client -> request(bring session_id) -> server
 *
 *                          loadbalancer (sticky session)
 *                         /    \       \
 *                      node1   node2   node3
 *                                      session(v1)
 */
