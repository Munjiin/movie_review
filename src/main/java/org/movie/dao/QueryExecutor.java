package org.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class QueryExecutor implements Executor{

    protected Connection con = null;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;

    public void executeAll(){

        try {
            makeConnection();
            doJob();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            closeAll();
        }
    }

    private void  makeConnection()throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection( "jdbc:oracle:thin:@10.10.10.95:1521:XE", "kk", "12345678");
    }

    private void closeAll(){
        System.out.println("close All...." + con);
        if(rs != null) {
            try { rs.close(); }catch(Exception e){}
        }
        if(stmt != null) {
            try { stmt.close(); }catch(Exception e){}
        }
        if(con != null) {
            try { con.close(); }catch(Exception e){}
        }
    }

}
//package org.movie.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
////1번
//public class QueryExecutor { //추상클래스
//
//
//    private Executor executor;
//
//    public QueryExecutor(Executor executor) {
//        this.executor = executor;
//    }
//
//
//    //connertion
//    public void executeAll(){
//        Connection con = null;
//
//
//        try {
//            con = makeConnection();
//            //execute();
//            executor.doJob();
//           // closeAll();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }finally {
//            closeAll(con);
//        } //throws Exception하면 오류나니 try로 바꿈
//    }//보여지는 부분
//
//    private Connection makeConnection()throws Exception{
//        System.out.println("makeConnection");
//        Class.forName("oracle.jdbc.OracleDriver");
//        return DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE",
//                "kk","12345678");
//    }
//
//    //protected void execute()throws Exception;//추상 메소드는 구현하지 않음.
//
//    private void closeAll(Connection con){
//        System.out.println("close all..");
//        if(con != null){
//            try{
//                con.close();
//            }catch (Exception e){}
//        }
//    }
//}
