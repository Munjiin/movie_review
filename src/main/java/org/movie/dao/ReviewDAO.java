package org.movie.dao;

import org.movie.domain.ReviewVO;

import java.util.ArrayList;
import java.util.List;

//영화 지정하면 영화 목록
public class ReviewDAO {
    public void updateChoice(int rno, String value){
        System.out.println("RNO: " + rno);
        System.out.println("VALUE: " + value);

        String sql = "update tbl_review set ";
        if(value.equals("g")){
            sql += "good = nvl(good,0) + 1 ";
        }else{
            sql += "bad = nvl(bad,0) + 1 ";
        }
        sql += " where rno =? ";

        String finalSql = sql;
        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                System.out.println(finalSql);
                stmt = con.prepareStatement(finalSql);
                stmt.setInt(1, rno);
                stmt.executeUpdate();
            }
        }.executeAll();


    }

    public void addReview(ReviewVO vo){
        String sql = "insert into tbl_review(mnum,score,cmt,rno)\n" +
                "values(?,?,?,seq_review.nextval)\n";
        //mnum,score,cmt
        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,vo.getMnum());
                stmt.setInt(2,vo.getScore());
                stmt.setString(3,vo.getCmt());

                stmt.executeUpdate(); //실행
            }
        }.executeAll();
    }//addReview

    public List<ReviewVO> getAllReviews(int mnum){
        List<ReviewVO> list = new ArrayList<>();
        String sql = "select mnum,score,cmt,reviewdate,rno,\n" +
                "nvl(good,0) good, nvl(bad,0) bad\n" +
                "from tbl_review\n" +
                "where mnum=?\n" +
                "order by rno desc";

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,mnum);
                rs=stmt.executeQuery();
                while(rs.next()){
                    ReviewVO vo = new ReviewVO();
//                    mnum,score,cmt,reviewdate,rno,
//                            nvl(good,0) good, nvl(bad,0) bad
                    vo.setMnum(rs.getInt(1)); //1칼럼
                    vo.setScore(rs.getInt(2));
                    vo.setCmt(rs.getString(3));
                    vo.setReviewdate(rs.getDate(4));
                    vo.setRno(rs.getInt(5));
                    vo.setGood(rs.getInt(6));
                    vo.setBad(rs.getInt(7));
                    list.add(vo);

                }//while
            }
        }.executeAll();


        return list;
    }//getAll

}


