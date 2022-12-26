package presentation.cn.ui;


import com.mysql.jdbc.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class link {

    void gaidong(){
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String JDBC_URL = "jdbc:mysql://localhost:3306/ood_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        String USER = "root";
        String PASSWORD = "20010228Lqy";

        Connection connection = null;

        Statement statement = null;


        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);

            statement = (Statement) connection.createStatement();


            String jia;
            String sql;
            String del;
            String mdf;
            int x = 0;
            String biaodan = null;
            String biaoqian = null;
            boolean biaoge1 = str.contains("movie");
            boolean biaoge2 = str.contains("screen");
            boolean biaoge3 = str.contains("screening");
            boolean biaoge4 = str.contains("ticket");
            if(biaoge1 == true){
                biaodan = "movie";
                x =1;
            }
            if(biaoge2 == true){
                biaodan = "screen";
                x = 2;
            }
            if(biaoge3 == true){
                biaodan = "screening";
                x = 3;
            }
            if(biaoge4 == true){
                biaodan = "ticket";
                x = 4;
            }

            boolean xuanxiang1 = str.contains("title");
            boolean xuanxiang2 = str.contains("running_time");
            boolean xuanxiang3 = str.contains("year");
            boolean xuanxiang4 = str.contains("screen_id");
            boolean xuanxiang5 = str.contains("capacity");
            boolean xuanxiang6 = str.contains("screening_id");
            boolean xuanxiang7 = str.contains("date");
            boolean xuanxiang8 = str.contains("time");
            boolean xuanxiang9 = str.contains("ticket_sold");
            boolean xuanxiang10 = str.contains("ticket_id");
            boolean xuanxiang11 = str.contains("movie_title");
            boolean xuanxiang12 = str.contains("seat_id");
            boolean xuanxiang13 = str.contains("price");


            if(xuanxiang1 == true){
                biaoqian = "title";
            }
            if(xuanxiang2 == true){
                biaoqian = "running_time";
            }
            if(xuanxiang3 == true){
                biaoqian = "year";
            }
            if(xuanxiang4 == true){
                biaoqian = "screen_id";
            }
            if(xuanxiang5 == true){
                biaoqian = "capacity";
            }
            if(xuanxiang6 == true){
                biaoqian = "screening_id";
            }
            if(xuanxiang7 == true){
                biaoqian = "date";
            }
            if(xuanxiang8 == true){
                biaoqian = "time";
            }
            if(xuanxiang9 == true){
                biaoqian = "ticket_sold";
            }
            if(xuanxiang10 == true){
                biaoqian = "ticket_id";
            }
            if(xuanxiang11 == true){
                biaoqian = "movie_title";
            }
            if(xuanxiang12 == true){
                biaoqian = "seat_id";
            }
            if(xuanxiang13 == true){
                biaoqian = "price";
            }




            boolean search = str.contains("search");
            boolean more = str.contains("add");
            boolean less = str.contains("delete");
            boolean modify = str.contains("change");


            if(search == true){
                sql = str.replace("search "+biaodan+" "+biaoqian,"SELECT * FROM "+biaodan+" WHERE "+biaoqian+"=");
                ResultSet rSet = statement.executeQuery(sql);

                while (rSet.next()) {
                    if (x == 1){
                        String a =rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3);
                        String[] arr = {a};
                        List<String> arlist = Arrays.asList(arr);
                        System.out.println(arlist);
                    }
                    if (x == 2){
                        String a =rSet.getString(1)+" "+rSet.getString(2);
                        String[] arr = {a};
                        List<String> arlist = Arrays.asList(arr);
                        System.out.println(arlist);
                    }
                    if (x == 3){
                        String a =rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3)+" "+rSet.getString(4)+" "+rSet.getString(5);
                        String[] arr = {a};
                        List<String> arlist = Arrays.asList(arr);
                        System.out.println(arlist);
                    }
                    if (x == 4){
                        String a =rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3)+" "+rSet.getString(4)+" "+rSet.getString(5)+" "+rSet.getString(6)+" "+rSet.getString(7)+" "+rSet.getString(8);
                        String[] arr = {a};
                        List<String> arlist = Arrays.asList(arr);
                        System.out.println(arlist);
                    }
                    //String a =rSet.getString(1)+rSet.getString(2)+rSet.getString(3)+rSet.getString(4);
                    //String[] arr = {a};
                    //List<String> arlist = Arrays.asList(arr);
                    //System.out.println(arlist);
                }
                rSet.close();
                statement.close();
                connection.close();
            }
            if(more == true){
                //INSERT INTO movie VALUES('008','109min','1980')
                jia = str.replace("add " + biaodan,"INSERT INTO "+biaodan+" VALUES");
                int aSet = statement.executeUpdate(jia);
                if(aSet >= 1){
                    System.out.println("You have successfully add new"+biaodan);
                }else {
                    System.out.println("失败");
                }
            }
            if(less == true){
                del = str.replace("delete " +biaodan,"DELETE FROM "+biaodan+" WHERE");
                int bSet = statement.executeUpdate(del);
                if (bSet >=1){
                    System.out.println("您已成功删除");
                }
            }
            if(modify == true){
                String mdf1 = str.replace("change "+biaodan+ "(","UPDATE "+biaodan+" SET ");
                mdf = mdf1.replace(")"," WHERE ");
                int cSet = statement.executeUpdate(mdf);
                if (cSet >= 1){
                    System.out.println("资料已修改");
                }
            }

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int x = 0;
        while (x<9999){
            link l = new link();
            l.gaidong();
            x++;
        }
    }




}
