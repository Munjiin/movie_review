package org.movie.web;

import org.movie.dao.MovieDAO;
import org.movie.dao.MovieDAO;
import org.movie.dao.QueryExecutor;
import org.movie.dao.ReviewDAO;
import org.movie.domain.MovieVO;
import org.movie.domain.ReviewVO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        new ReviewDAO().getAllReviews(16).stream().forEach(v-> System.out.println(v));

        ReviewVO vo = new ReviewVO();
        vo.setMnum(20);
        vo.setCmt("한글 테서터,,");
        vo.setScore(3);
        new ReviewDAO().addReview(vo);




//        new MovieDAO().getList().stream().forEach(m-> System.out.println(m));
//
//        MovieVO vo = new MovieDAO().getMovie(8);
//        System.out.println(vo);
//
//        new MovieDAO().getImgs(8).stream().forEach(img -> System.out.println(img));



//        String name ="Transformer";
//        List<MovieVO> list = new ArrayList<>();
//
//        new QueryExecutor() {
//            @Override
//            public void doJob() throws Exception {
//                stmt = con.prepareStatement("select sysdate from dual");
//                rs = stmt.executeQuery();
//                while(rs.next()){
//                    System.out.println(rs.getString(1));
//                }
//            }
//        }.executeAll();

    }
}
//package org.movie.web;
////3번
//import QueryExecutor;
//import MovieVO;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
////
////        TestExecutor executor = new TestExecutor();
////        executor.executeAll();
//
//        //익명클래스 . 위와 같은 결과지만 이름이 없는 클래스.
//        // 원래는 execute에 파라미터 전달 불가하나 익클은 자기의 바깥쪽 변수 어세스가능.
//        String name="transformer";
//        List<MovieVO> list = new ArrayList<>();
//
//
//
//        new QueryExecutor(()->{
//            System.out.println("dojob" + name);
//        }).executeAll();
//
//    }
//}
