package com.example.java4il2022.week4;


/**
 *  diff encoding vs encryption
 *
 *  hashing / hash
 *
 *  1. authentication (username - password / text / email / two factor login)
 *  2. authorization (role)
 *      JWT => Json Web Token
 *          header.payload.signature
 *
 *          encode(header.payload.encrypt(header.payload))
 *
 *  3. https
 *      Symmetric key
 *      Asymmetric key : public key + private key
 *      SSL
 *      public key          private key
 *      client      ->      server
 *                  <-
 *               random string
 *                  ->
 *               hash(string)
 *                  <-
 *         generate symmetric key
 *                  ..
 *
 *  4. sql injection
 *      "\"or true; drop table..\""
 *
 *      String sql = "select .. from where username = " + username + " and password = " + password;
 *  5. firewall
 *
 *  filter1 <-> filter2 <-> dispatcher servlet  -> handler mapping -> controller
 *
 *  Spring Security
 *                                                      interface  UserDetailsService + UserDetails
 *                                                              /
 *                         AuthenticationManager  -> DaoAuthenticationProvider(username password) / provider2(email) / ..code /
 *                      /               \       \
 *  AuthenticationFilter <-> JWTFilter <-> ..filter  <-> controller
 *                              \           /
 *                           SecurityContext(ThreadLocal)
 *
 *
 *
 *
 *
 *
 *
 */