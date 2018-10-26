package org.movie.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MovieVO {

    private int mnum,runtime;
    private String mtitle,director,actors,grade, poster;
    private Date opendate,regdate;

//    @Override
//    public String toString() {
//        return "MovieVO{" +
//                "mnum=" + mnum +
//                ", runtime=" + runtime +
//                ", mtitle='" + mtitle + '\'' +
//                ", director='" + director + '\'' +
//                ", actors='" + actors + '\'' +
//                ", grade='" + grade + '\'' +
//                ", poster='" + poster + '\'' +
//                ", opendate=" + opendate +
//                ", regdate=" + regdate +
//                '}';
//    }
//
//    public int getMnum() {
//        return mnum;
//    }
//
//    public void setMnum(int mnum) {
//        this.mnum = mnum;
//    }
//
//    public int getRuntime() {
//        return runtime;
//    }
//
//    public void setRuntime(int runtime) {
//        this.runtime = runtime;
//    }
//
//    public String getMtitle() {
//        return mtitle;
//    }
//
//    public void setMtitle(String mtitle) {
//        this.mtitle = mtitle;
//    }
//
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public String getActors() {
//        return actors;
//    }
//
//    public void setActors(String actors) {
//        this.actors = actors;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public String getPoster() {
//        return poster;
//    }
//
//    public void setPoster(String poster) {
//        this.poster = poster;
//    }
//
//    public Date getOpendate() {
//        return opendate;
//    }
//
//    public void setOpendate(Date opendate) {
//        this.opendate = opendate;
//    }
//
//    public Date getRegdate() {
//        return regdate;
//    }
//
//    public void setRegdate(Date regdate) {
//        this.regdate = regdate;
//    }
}
