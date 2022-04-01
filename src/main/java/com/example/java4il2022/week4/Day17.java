package com.example.java4il2022.week4;

/**
 *  Web service
 *      SOAP API
 *      Rest API
 *          1. Http
 *          2. Http method
 *              get
 *              post
 *              put
 *              patch
 *              delete
 *          3. Http status code
 *              200 : success OK
 *              201 : created
 *              204 : success no content
 *
 *              400 : bad request
 *              401 :
 *              403 :
 *              404 : not found
 *
 *              500 : internal server error
 *          4. url , endpoint , api
 *              /employees?age=15  get
 *              /employees  post
 *              /employees/{emp_id}  get
 *              /employees/{emp_id}  put
 *              /employees/{emp_id}  delete
 *          5. stateless
 *
 *   question:
 *      design restful api for student
 *
 *          1. table / data model
 *              student (id, name, age, last_login_time, active, created_time)
 *          2. design restful api
 *              create student
 *                  http method: post
 *                  url : /students
 *                  http header: content type : json / accept : json
 *                  request body :
 *                      {
 *                           {
 *                              "name" : "^&*(^&*%&(",
 *                              "age"  : -5
 *                           }
 *                      }
 *                  response body :
 *                      {
 *                          "location" : id
 *                      }
 *                  status code
 *                      201 : created
 *                      400 :
 *                      401 :
 *                      500 :
 *              get all students
 *                  http method : get
 *                  url : /students?pageNumber=2&pageCount=10
 *                  response body
 *                      Pagination
 *                      {
 *                          timestamp : ..
 *                          pageNumber : 2,
 *                          pageCount  : 10,
 *                          totalCount : 5343,
 *                          content : [
 *                              {
 *                                  "id"  : xx
 *                                  "name": "..",
 *                                  "age" : 39
 *                              },
 *                              {
                                    "id"  : xx
 *                                  "name": "..",
 *                                  "age" : 39
 *                              }
 *                          ]
 *                      }
 *                  status code
 *                      200
 *                      ..
 *              get one student by id
 *                  http method : get
 *                  url : /students/{id}
 *                  response body
 *                      {
 *                          "id": xx
 *                          "name": xx
 *                          "age" :..
 *                      }
 *                  status code
 *                      200
 *                      404
 *                      500
 *              delete student by id
 *              update student by id
 *
 *
 *   question:
 *      TDD
 *      After you get a requirement, what should you do ?
 *          1. design flow / api / features
 *          2. uncleared questions -> BA / QA / Manager / Leader
 *          3. ODD skeleton / Class / interface with TODO
 *          4. Test
 *          5. impl TODO
 *          6. run Test
 *
 *   question:
 *      what is good restful api
 *          1. URL
 *          2. HTTP method / status code / header
 *          3. exception handling
 *              a. log -> metric / alert / debugging
 *              b. give user customized response
 *          4. security
 *          5. performance
 *          6. class / interface / abstract class
 *          7. Test
 *          8. documentation
 *          ...
 *
 */
class Day17Test {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[5]);
    }
}