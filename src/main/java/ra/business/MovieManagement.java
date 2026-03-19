package ra.business;

import ra.entity.Movie;
import java.util.Scanner;

public class MovieManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieBusiness business = MovieBusiness.getInstance();
        while (true) {
            System.out.println("\n********* QUAN LY DANH MUC PHIM **********");
            System.out.println("1. Hien thi danh sach toan bo phim");
            System.out.println("2. Them moi phim");
            System.out.println("3. Cap nhat thong tin theo ma phim");
            System.out.println("4. Xoa phim theo ma phim");
            System.out.println("5. Tim kiem phim theo ten");
            System.out.println("6. Loc danh sach phim thinh hanh (view >= 10000)");
            System.out.println("7. Sap xep danh sach phim giam dan theo luot xem");
            System.out.println("8. Thoat");
            System.out.print("Moi ban chon (1-8): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so tu 1 den 8!");
                continue;
            }
            switch (choice) {
                case 1:
                    business.displayAll();
                    break;
                case 2:
                    boolean isContinue = true;
                    do {
                        Movie newMovie = new Movie();
                        newMovie.inputData(sc);
                        if (business.addMovie(newMovie)) {
                            System.out.println("Them phim thanh cong");
                        }
                        System.out.print("Tiep tuc them phim(Y/N): ");
                        if (sc.nextLine().equalsIgnoreCase("N")) isContinue = false;
                    } while (isContinue);
                    break;
                case 3:
                    System.out.print("Nhap ma phim can cap nhat: ");
                    String editId = sc.nextLine();
                    Movie movieToEdit = business.findById(editId);
                    if (movieToEdit == null) {
                        System.out.println("Khong tim thay ma phim nay");
                    } else {
                        boolean isEditing = true;
                        while (isEditing) {
                            System.out.println("\n-- CAP NHAT: " + movieToEdit.getMovieName() + " --");
                            System.out.println("1. Cap nhat ten");
                            System.out.println("2. Cap nhat thoi luong");
                            System.out.println("3. Cap nhat luot xem");
                            System.out.println("4. Quay lai");
                            System.out.print("Chon muc: ");
                            try {
                                int sub = Integer.parseInt(sc.nextLine());
                                if (sub == 1) {
                                    System.out.print("Ten moi: ");
                                    movieToEdit.setMovieName(sc.nextLine());
                                } else if (sub == 2) {
                                    System.out.print("Thoi luong moi: ");
                                    movieToEdit.setDuration(Integer.parseInt(sc.nextLine()));
                                } else if (sub == 3) {
                                    System.out.print("Luot xem moi: ");
                                    movieToEdit.setViews(Integer.parseInt(sc.nextLine()));
                                } else if (sub == 4) {
                                    isEditing = false;
                                } else {
                                    System.out.println("Chon tu 1-4");
                                }
                            } catch (Exception e) {
                                System.out.println("Nhap so hop le");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma phim can xoa: ");
                    if (business.removeMovie(sc.nextLine())) System.out.println("Xoa thanh cong");
                    else System.out.println("Khong tim thay ma phim!");
                    break;
                case 5:
                    System.out.print("Nhap ten phim: ");
                    business.searchMovieByName(sc.nextLine());
                    break;
                case 6:
                    business.filterPopularMovies();
                    break;
                case 7:
                    business.sortMovieByView();
                    business.displayAll();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Loi: Lua chon khong hop le");
            }
        }
    }
}