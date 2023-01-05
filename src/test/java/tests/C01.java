package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C01 {

    //ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın


    @Test
    public void test01() throws SQLException {
        String hostname = "localhost";
        String dbisim = "Databasetesting";
        String username = "postgres";
        String password = "javaogreniyorum";
        // 1. adim: connection olustur
        DBUtils.connectionOlustur(hostname,dbisim,username,password);

        //2. adim : Statement olustur
        Statement st = DBUtils.statementOlustur();

        //3. adim :query olustur
        String query = "select isim from ogrenciler";

        //4. adim: query'i calistir
        ResultSet rs = st.executeQuery(query);
        List<String> isimler = new ArrayList<>();

        while (rs.next()){
            isimler.add(rs.getString(1));
        }
        Assert.assertTrue(isimler.contains("Merve Gul"));

        //5. adim :
        DBUtils.connectionStatementKapat();




    }
}
