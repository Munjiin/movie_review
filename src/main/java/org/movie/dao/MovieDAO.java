package org.movie.dao;


import org.movie.domain.MovieVO;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public List<MovieVO> getList(){

      List<MovieVO> list = new ArrayList<MovieVO>();

      final String sql="select * from tbl_movie order by mnum desc";

      new QueryExecutor(){
          public void doJob() throws Exception{
              stmt = con.prepareStatement(sql);
              rs = stmt.executeQuery();
              while (rs.next()){
                  MovieVO vo = new MovieVO();
                  vo.setMnum(rs.getInt("mnum"));
                  vo.setMtitle(rs.getString("mtitle"));
                  vo.setActors(rs.getString("actors"));
                  vo.setPoster(rs.getString("poster"));


                  list.add(vo);
              }
          }
      }.executeAll();

      return list;
    }

    public MovieVO getMovie(int mnum){
        List<MovieVO> list = new ArrayList<MovieVO>();

        MovieVO vo = new MovieVO();
        //code
        final String sql = "select * from tbl_movie where mnum =?";

        new QueryExecutor(){
            public void doJob() throws Exception{
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,mnum);
                rs = stmt.executeQuery();

                while (rs.next()){

                    vo.setMnum(rs.getInt("mnum"));
                    vo.setMtitle(rs.getString("mtitle"));
                    vo.setActors(rs.getString("actors"));
                    vo.setPoster(rs.getString("poster"));


                    list.add(vo);
                }
            }
        }.executeAll();
        return vo;
    }

    public List<String> getImgs(int mnum){
        List<String> list = new ArrayList<>();
        final String sql = "select * from tbl_movie_img where mnum= ?";
        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,mnum);
                rs = stmt.executeQuery();

                while (rs.next()){

                    list.add(rs.getString("fname"));
                }
            }


        }.executeAll();

        //code
        return list;
    }
}
