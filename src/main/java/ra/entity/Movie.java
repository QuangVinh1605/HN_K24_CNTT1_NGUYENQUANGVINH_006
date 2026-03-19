package ra.entity;

import java.util.Scanner;

public class Movie {
    protected String movieId;
    protected String movieName;
    protected int duration;
    protected int views;

    public Movie() {}

    public Movie(String movieId, String movieName, int duration, int views) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.views = views;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void inputData(Scanner sc) {
        while (true) {
            System.out.println("Nhap ID phim:");
            this.movieId = sc.nextLine().trim();
            if (!this.movieId.isEmpty()) break;
            System.out.println("ID khong duoc de trong");
        }

        while (true) {
            System.out.println("Nhap ten phim:");
            this.movieName = sc.nextLine().trim();
            if (!this.movieName.isEmpty()) break;
            System.out.println("Ten khong duoc de trong");
        }

        while (true) {
            try {
                System.out.println("Nhap thoi luong (phut):");
                this.duration = Integer.parseInt(sc.nextLine());
                if (this.duration > 0) break;
                System.out.println("Thoi luong phai lon hon 0");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen");
            }
        }

        while (true) {
            try {
                System.out.println("Nhap so luot xem:");
                this.views = Integer.parseInt(sc.nextLine());
                if (this.views >= 0) break;
                System.out.println("Luot xem khong duoc am");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen");
            }
        }
    }

    public void displayData() {
        System.out.printf("[Phim] ID: %-5s | Ten: %-15s | Thoi luong: %-5d | Luot xem: %-7d\n",
                movieId, movieName, duration, views);
    }
}